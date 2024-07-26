package com.rest.springrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.rest.springrest.Service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable
    {
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long endtTime = System.currentTimeMillis();
        LOGGER.info("time taken : "+startTime+" "+endtTime+" ms");
        return result;
    }
}
