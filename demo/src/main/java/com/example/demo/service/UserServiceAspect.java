package com.example.demo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    // runs before execution
    @Before(value="execution(* com.example.demo.UserServiceAspect")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("UserServiceAspect.beforeAdvice");
    }

    @After(value = "execution(* com.example.demo.UserServiceAspect")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("UserServiceAspect.afterAdvice");
    }

    @AfterReturning(value = "execution(* com.example.demo.UserServiceAspect")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("UserServiceAspect.afterReturning");
    }

    @Around(value = "execution(* com.example.demo.UserServiceAspect")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("UserServiceAspect.aroundAdvice");

        try {
            joinPoint.proceed();
        }
        catch (Throwable e) {
            System.out.println("e = " + e);
        }
    }

}
