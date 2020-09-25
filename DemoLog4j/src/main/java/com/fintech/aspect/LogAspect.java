package com.fintech.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.AfterAdvice;

@Aspect
public class LogAspect {
    private static final Logger logger = Logger.getLogger(LogAspect.class);

    @Before("execution(* com.fintech.controller.DemoLog4jServlet.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.debug("before i fall in love with you ");
    }

    @After("execution(* com.fintech.controller.DemoLog4jServlet.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("after i fall in love with you");
    }
}
