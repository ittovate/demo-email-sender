package com.example.SenderEmail.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(AroundAspects.class);


    @After("execution (* com.example.SenderEmail.*.*.*(..))")
    public void after(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        LOGGER.info(" After: From method : {} in class : {} ", methodName , className );
    }


    @AfterReturning("execution (* com.example.SenderEmail.*.*.*(..))")
    public void afterReturning(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        LOGGER.info(" After Returning: From method : {} in class : {} ", methodName , className );
    }


    @AfterThrowing(
            pointcut = "execution (* com.example.SenderEmail.service.*.*(..))",
            throwing = "ex", argNames = "jp,ex")
        public void afterThrowing(JoinPoint jp, RuntimeException ex) {
        String className =  ex.getClass().getSimpleName();
        String methodName = ex.getStackTrace()[0].getMethodName();
        String exceptionMessage = ex.getMessage();
        LOGGER.error(" Exception: From method : ' {} ' in class : ' {} '  , message exception : {}", methodName , className , exceptionMessage);
    }
}
