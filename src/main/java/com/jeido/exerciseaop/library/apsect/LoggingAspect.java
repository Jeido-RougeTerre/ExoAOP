package com.jeido.exerciseaop.library.apsect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(com.jeido.exerciseaop.library.annotation.AroundAnnotation)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        try {
            Object[] args = joinPoint.getArgs();
            System.out.printf("Entering '%s'  %s%n", methodName, args.length > 0 ? "with args " + Arrays.toString(joinPoint.getArgs()) : "without args");

            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("Exiting '%s' : %s%n", methodName, result);
        }
        return result;

    }
}


