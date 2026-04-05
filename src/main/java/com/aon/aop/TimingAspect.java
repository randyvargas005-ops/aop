package com.aon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimingAspect {

    @Around("@annotation(Timed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.nanoTime();

        Object result = joinPoint.proceed();

        long duration = System.nanoTime() - start;

        System.out.println(joinPoint.getSignature().getName() +
                " took " + duration + " ns");

        return result;
    }
}