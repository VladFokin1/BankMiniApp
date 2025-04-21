package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* org.example.service.UserService.*(..))")
    public void log(
            JoinPoint joinPoint
    ) {
        System.out.println("After loggable" + joinPoint.getSignature().getName());
    }
}
