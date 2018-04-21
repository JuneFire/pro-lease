package com.design.lease.ws.builder;

import com.design.lease.ws.bo.WsConfig;
import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.utils.JacksonObjectUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WsBeanInvokeBuilder implements WsBeanInvoke,ApplicationContextAware{

    private static final Logger logger = LoggerFactory.getLogger(WsBeanInvokeBuilder.class.getName());

    private ApplicationContext applicationContext;

    public WsResponseMsgVO invoke(String param, WsConfig wsConfig) {
        String methodName = wsConfig.getMethod();
        Object object = wsConfig.getObject();
        try {
            logger.info("method = {},Object = {}", methodName, object.getClass().getName());
            Class[] clazzes = new Class[wsConfig.getParams().values().size()];
            int i = 0;
            for (Class<?> clazz : wsConfig.getParams().values()) {
                clazzes[i] = clazz;
                i++;
            }
            Method method = object.getClass().getMethod(methodName, clazzes);
            ObjectMapper mapper = JacksonObjectUtils.getMapper();
            JsonNode root = mapper.readTree(param);
            JsonNode bodyNode = root.path("body");
            JsonNode headNode = root.path("head");
            Object head = mapper.readValue(String.valueOf(headNode),clazzes[0]);
            Object body = mapper.readValue(String.valueOf(bodyNode), clazzes[1]);
            Object reObject = method.invoke(applicationContext.getBean(wsConfig.getBeanName()), head, body);
            return (WsResponseMsgVO) reObject;
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e);
            return new WsResponseMsgVO().buildUnknownErrorResponse("IllegalAccessException");
        } catch (InvocationTargetException e) {
            logger.error("InvocationTargetException", e);
            return new WsResponseMsgVO().buildUnknownErrorResponse("InvocationTargetException");
        } catch (NoSuchMethodException e) {
            logger.error("IllegalAccessException", e);
            return new WsResponseMsgVO().buildNotFundErrorResponse();
        } catch (IOException e) {
            logger.error("IllegalAccessException", e);
            return new WsResponseMsgVO().buildNotFundErrorResponse();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
