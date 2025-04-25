package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {

    @AfterReturning(value = "execution(* org.example.service.UserService.createUser(..))",
            returning = "result")
    public void logUserCreated(
            JoinPoint joinPoint,
            Object result
    ) {
        System.out.println("User created: " + result);
    }

    @AfterThrowing(
            value = "execution(* org.example.service.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowingExceptionLog(
            JoinPoint joinPoint,
            Exception exception
    ) {
        System.out.println(exception.getMessage());
    }
}
