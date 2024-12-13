package com.jeido.exerciseaop.library.apsect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    @AfterThrowing(value = "@annotation(com.jeido.exerciseaop.library.annotation.ExceptionAnnotation)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.printf("Exception: %s\n%s\n", joinPoint.getSignature().getName(), e.getMessage());
    }
}
