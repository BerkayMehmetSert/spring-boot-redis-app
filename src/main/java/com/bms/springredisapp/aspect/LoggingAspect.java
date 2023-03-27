package com.bms.springredisapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.bms.springredisapp.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        LOGGER.info("Before Controller Method: " + joinPoint.getSignature().getName());
        LOGGER.info("Before Controller Parameters: " + joinPoint.getArgs());
        LOGGER.info("Before Controller Target: " + joinPoint.getTarget());
    }

    @Before("execution(* com.bms.springredisapp.service.*.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        LOGGER.info("Before Service Method: " + joinPoint.getSignature().getName());
        LOGGER.info("Before Service Parameters: " + joinPoint.getArgs());
        LOGGER.info("Before Service Target: " + joinPoint.getTarget());
    }

    @Before("execution(* com.bms.springredisapp.repository.*.*(..))")
    public void logBeforeRepository(JoinPoint joinPoint) {
        LOGGER.info("Before Repository Method: " + joinPoint.getSignature().getName());
        LOGGER.info("Before Repository Parameters: " + joinPoint.getArgs());
        LOGGER.info("Before Repository Target: " + joinPoint.getTarget());
    }

    @AfterReturning(pointcut = "execution(* com.bms.springredisapp.controller.*.*(..))", returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        LOGGER.info("After Controller Method: " + joinPoint.getSignature().getName());
        LOGGER.info("After Controller Parameters: " + joinPoint.getArgs());
        LOGGER.info("After Controller Target: " + joinPoint.getTarget());
        LOGGER.info("After Controller Result: " + result);
    }

    @AfterReturning(pointcut = "execution(* com.bms.springredisapp.service.*.*(..))", returning = "result")
    public void logAfterService(JoinPoint joinPoint, Object result) {
        LOGGER.info("After Service Method: " + joinPoint.getSignature().getName());
        LOGGER.info("After Service Parameters: " + joinPoint.getArgs());
        LOGGER.info("After Service Target: " + joinPoint.getTarget());
        LOGGER.info("After Service Result: " + result);
    }

    @AfterReturning(pointcut = "execution(* com.bms.springredisapp.repository.*.*(..))", returning = "result")
    public void logAfterRepository(JoinPoint joinPoint, Object result) {
        LOGGER.info("After Repository Method: " + joinPoint.getSignature().getName());
        LOGGER.info("After Repository Parameters: " + joinPoint.getArgs());
        LOGGER.info("After Repository Target: " + joinPoint.getTarget());
        LOGGER.info("After Repository Result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.bms.springredisapp.service.*.*(..))", throwing = "exception")
    public void logAfterThrowingService(JoinPoint joinPoint, Throwable exception) {
        LOGGER.info("After Throwing Service Method: " + joinPoint.getSignature().getName());
        LOGGER.info("After Throwing Service Parameters: " + joinPoint.getArgs());
        LOGGER.info("After Throwing Service Target: " + joinPoint.getTarget());
        LOGGER.info("After Throwing Service Exception: " + exception);
    }
}
