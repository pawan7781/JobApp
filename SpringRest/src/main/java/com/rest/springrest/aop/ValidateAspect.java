package com.rest.springrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(ValidateAspect.class);
    @Around("execution(* com.rest.springrest.Service.JobService.getJob(..))&& args(postId)")
    public Object ValidateAspect(ProceedingJoinPoint jp, int postId)throws Throwable {
        if(postId<0)
        {
            LOGGER.info("negative postId: updating");
            postId=-postId;
            LOGGER.info("new value: "+postId);
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
