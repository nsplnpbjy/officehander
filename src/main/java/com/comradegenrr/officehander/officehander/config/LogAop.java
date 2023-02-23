package com.comradegenrr.officehander.officehander.config;

import java.io.InputStream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Aspect
@Component
public class LogAop {

    private String ip;
    
    @Around("execution(* com.comradegenrr.officehander.officehander.controller.mainController.*(..))")
    public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger = LoggerFactory.getLogger(LogAop.class);
        MultipartHttpServletRequest request = (MultipartHttpServletRequest) joinPoint.getArgs()[0];
        ip = request.getHeader("x-forwarded-for");
        String methodName = joinPoint.getSignature().getName();
        logger.info(ip+"  "+methodName+" 开始执行");
        return joinPoint.proceed();
    }

    @Around("execution(* com.comradegenrr.officehander.officehander.util.MergeUtil.*(..))")
    public Object mergeUtilLog(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger logger = LoggerFactory.getLogger(LogAop.class);
        String methodName = joinPoint.getSignature().getName();
        logger.info(ip+"  "+methodName+" 开始执行");
        InputStream inputStream = (InputStream) joinPoint.proceed();
        logger.info(ip+"  "+methodName+" 执行完毕");
        return inputStream;
    }
}
