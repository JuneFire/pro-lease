package com.design.lease.aop;

import com.design.lease.constant.WsConstatnt;
import com.design.lease.ws.target.NeedValidation;
import com.design.lease.ws.utils.CookieUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
public class HeadAspect {

    private static final String EXECUTION = "execution(* com.design.lease.*.controller.*.*(..))";

    private static final Logger logger = LoggerFactory.getLogger(HeadAspect.class);

    @Around(value = EXECUTION)
    public Object aroundProceed(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("拦截到了{}方法...",joinPoint.getSignature().getName());
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        Class clazz = method.getClass();

        if (clazz.isAnnotationPresent(NeedValidation.class)){
            NeedValidation needValidation = (NeedValidation) clazz.getAnnotation(NeedValidation.class);
            if (needValidation.login() && !checkLogin()){
                logger.info("校验信息不通过");
                throw new Exception("前置校验未通过.");
            }
        }

        Object object = joinPoint.proceed();
        return object;
    }

    public boolean checkLogin(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie cookie = CookieUtils.getCookie(WsConstatnt.UID_COOKIE,request);
        return cookie != null;
    }

}
