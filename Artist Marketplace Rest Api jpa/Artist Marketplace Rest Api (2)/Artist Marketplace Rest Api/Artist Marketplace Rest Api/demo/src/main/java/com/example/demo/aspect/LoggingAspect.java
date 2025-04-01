package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        System.out.println("[LOGGING ASPECT] Before: " + joinPoint.getSignature());
    }

    @After("execution(* com.example.demo.controller.*.*(..))")
    public void logAfterControllerMethods(JoinPoint joinPoint) {
        System.out.println("[LOGGING ASPECT] After: " + joinPoint.getSignature());
    }
}
