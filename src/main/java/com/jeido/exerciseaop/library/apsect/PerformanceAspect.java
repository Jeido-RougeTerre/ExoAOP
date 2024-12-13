package com.jeido.exerciseaop.library.apsect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private long startTime;


    @Pointcut("@annotation(com.jeido.exerciseaop.library.annotation.AroundAnnotation)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @AfterReturning("pointCut()")
    public void after(JoinPoint joinPoint) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.printf("Done in %dms\n", elapsedTime);
    }
}
