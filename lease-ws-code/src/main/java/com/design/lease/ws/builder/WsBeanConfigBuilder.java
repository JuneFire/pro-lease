package com.design.lease.ws.builder;

import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.exception.WsConfigurationException;
import com.design.lease.ws.target.Route;
import com.design.lease.ws.target.Ws;
import com.design.lease.ws.target.WsNameSpace;
import org.objectweb.asm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class WsBeanConfigBuilder implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(WsBeanConfigBuilder.class.getName());

    private ApplicationContext applicationContext;

    private List<WsConfig> wsConfigs = new ArrayList<WsConfig>();

    public void initWsConfig() {
        // 查询所有使用了Ws标签注解的beanName
        String[] beanNames = applicationContext.getBeanNamesForAnnotation(Ws.class);
        for (String beanName : beanNames) {
            try {
                Class beanClass = applicationContext.getType(beanName);
                Class clazz = Class.forName(beanClass.getName().substring(0,beanClass.getName().indexOf("$$")));
                if (clazz.isAnnotationPresent(WsNameSpace.class)) {
                    WsNameSpace wsNameSpacesAnnotation = (WsNameSpace) clazz.getAnnotation(WsNameSpace.class);
                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Route.class)) {
                            Route route = method.getAnnotation(Route.class);
                            this.buildWsConfig(wsNameSpacesAnnotation, route, method, clazz,beanName);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildWsConfig(WsNameSpace wsNameSpace, Route route, Method method, Class clazz,String beanName) throws IllegalAccessException, InstantiationException {
        WsConfig wsConfig = new WsConfig();
        String path = wsNameSpace.value() + route.value();
        wsConfig.setPath(path);
        wsConfig.setRoute(route.value());
        wsConfig.setClassName(clazz.getName());
        wsConfig.setMethod(method.getName());
        wsConfig.setObject(clazz.newInstance());
        wsConfig.setParams(getMethodParam(clazz, method));
        wsConfig.setWsNameSpace(wsNameSpace.value());
        wsConfig.setBeanName(beanName);
        wsConfigs.add(wsConfig);
    }

    public Map<String, Class<?>> getMethodParam(Class<?> clazz, final Method method) {
        final Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return new HashMap<String, Class<?>>();
        }
        String[] paramName = getMethodParameterNamesByAsm4(clazz, method);
        logger.info("paramName = {}",Arrays.toString(paramName));
        logger.info("parameterTypes = {}",Arrays.toString(parameterTypes));
        Map<String, Class<?>> map = new LinkedHashMap<String, Class<?>>();
        for (int i = 0; i < paramName.length; i++) {
            map.put(paramName[i], parameterTypes[i]);
        }
        return map;
    }

    /**
     * 获取指定类指定方法的参数名
     *
     * @param clazz  要获取参数名的方法所属的类
     * @param method 要获取参数名的方法
     * @return 按参数顺序排列的参数名列表，如果没有参数，则返回null
     */
    public String[] getMethodParameterNamesByAsm4(Class<?> clazz, final Method method) {
        final Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return null;
        }
        final org.springframework.asm.Type[] types = new org.springframework.asm.Type[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            types[i] = org.springframework.asm.Type.getType(parameterTypes[i]);
        }
        final String[] parameterNames = new String[parameterTypes.length];

        String className = clazz.getName();
        int lastDotIndex = className.lastIndexOf(".");
        className = className.substring(lastDotIndex + 1) + ".class";
        InputStream is = clazz.getResourceAsStream(className);
        try {
            ClassReader classReader = new ClassReader(is);
            classReader.accept(new ClassVisitor(Opcodes.ASM4) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                                 String[] exceptions) {
                    // 只处理指定的方法
                    org.springframework.asm.Type[] argumentTypes = org.springframework.asm.Type.getArgumentTypes(desc);
                    if (!method.getName().equals(name) || !Arrays.equals(argumentTypes, types)) {
                        return null;
                    }
                    return new MethodVisitor(Opcodes.ASM4) {

                        /**
                         * visitLocalVariable方法获取的是方法内部声明的所有变量（方法返回参数+方法入参+
                         * 方法内部变量声明）
                         */
                        @Override
                        public void visitLocalVariable(String name, String desc, String signature, Label start,
                                                       Label end, int index) {

                            if (index > parameterNames.length) {
                                return;
                            }
                            // 静态方法第一个参数就是方法的参数，如果是实例方法，第一个参数是this
                            if (Modifier.isStatic(method.getModifiers())) {
                                parameterNames[index] = name;
                                // index = 0为返回参数,因此index=1开始才为入参
                            } else if (index > 0) {
                                parameterNames[index - 1] = name;
                            }
                        }
                    };
                }
            }, 0);
        } catch (IOException e) {
            logger.error("ws " + clazz.getName() + "方法" + method.getName() + "不存在", e);
            throw new WsConfigurationException("ws " + clazz.getName() + "方法" + method.getName() + "不存在", e);
        }
        return parameterNames;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public List<WsConfig> getWsConfigs(){
        return wsConfigs;
    }

}
