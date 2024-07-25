package com.example.SenderEmail.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @AfterThrowing( value = "execution(* com.example.SenderEmail.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String  methodName = joinPoint.getSignature().getName() ;
        String className = joinPoint.getTarget().getClass().getName() ;
        LOGGER.error(" Exception from AOP : From method : ' {} ' in class : ' {} '  , message exception : {}", methodName , className , ex.getMessage());
    }


    @Around("execution( * com.example.SenderEmail.service.EmailService.sendEmail(..) )")
    public void loggerAround (ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis() ;

        LOGGER.info(" Entering sendEmail method. Preparing to send email. ") ;
        LOGGER.info(" start check the data come from client is valued or not   ") ;

        joinPoint.proceed();

        long executionTime =System.currentTimeMillis() - start ;

        LOGGER.info(" sendEmail method finished. Total execution time: {} ms " , executionTime);

    }


}
