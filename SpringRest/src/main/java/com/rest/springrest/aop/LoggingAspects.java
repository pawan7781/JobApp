package com.rest.springrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspects {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspects.class);
//     for a class-
    @Before("execution(* com.rest.springrest.Service.JobService.*(..))")
    public void logmethodcall()
    {
        LOGGER.info( "Method called" );
    }

// for perticular method , we can also use pipe symbol for more methods
    @Before("execution(* com.rest.springrest.Service.JobService.getJob(..))")
    public void logmethodcall(JoinPoint jp)
    {
        LOGGER.info( "Method called" + " " +jp.getSignature().getName());
    }
// after used for - after the execution of code-
    @After("execution(* com.rest.springrest.Service.JobService.getJob(..))")
    public void logmethodExecute(JoinPoint jp)
    {
        LOGGER.info( "Method executed" + " " +jp.getSignature().getName());
    }
// it will run only when some exception or issue occured
    @AfterThrowing("execution(* com.rest.springrest.Service.JobService.getJob(..))")
    public void logmethodCrash(JoinPoint jp)
    {
        LOGGER.info( "Method issue occured" + " " +jp.getSignature().getName());
    }
//when there is no exception

    @AfterReturning ("execution(* com.rest.springrest.Service.JobService.getJob(..))")
    public void logmethodSuccess(JoinPoint jp)
    {
        LOGGER.info( "Method executed successfully" + " " +jp.getSignature().getName());
    }


}
