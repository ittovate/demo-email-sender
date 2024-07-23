package com.example.SenderEmail.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspects {

    @After("execution (* com.example.SenderEmail.*.*.*(..))")
    public void after(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();

        System.out.println("After class name   = " + className);
        System.out.println("After method name  = " + methodName);

    }


    @AfterReturning("execution (* com.example.SenderEmail.*.*.*(..))")
    public void afterReturning(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();

        System.out.println("AfterReturning class name  = " + className);
        System.out.println("AfterReturning method name = " + methodName);

    }


    @AfterThrowing(
            pointcut = "execution (* com.example.SenderEmail.service.EmailService.sendEmail(..))",
            throwing = "ex", argNames = "ex,jp")
        public void afterThrowing(RuntimeException ex, JoinPoint jp) {


        String className =  ex.getClass().getSimpleName();
        String methodName = ex.getStackTrace()[0].getMethodName();
        String exceptionMessage = ex.getMessage();

        System.out.println("AfterThrowing class name          = " + className);
        System.out.println("AfterThrowing method name         = " + methodName);
        System.out.println("AfterThrowing exception message   = " + exceptionMessage);

    }
}
