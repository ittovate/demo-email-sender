package com.example.SenderEmail.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class is an Aspect component used for logging method executions and exceptions in the application.
 * It uses Aspect-Oriented Programming (AOP) .
 * <p>
 * The {@code LoggerAspect} class contains two main aspects:
 * <ul>
 *    1-  <li>{@code logAfterThrowing}: Logs information about exceptions thrown by methods in the
 *     {@code com.example.SenderEmail.service} package.</li>
 *     <br>
 *    2- <li>{@code loggerAround}: Logs entry, exit, and execution time for the
 *     {@code sendEmail} method in the {@code EmailService} class.</li>
 * </ul>
 */
@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);


    /**
     * Logs information about exceptions thrown by methods in the
     * {@code com.example.SenderEmail.service} package.
     *

     */
    @AfterThrowing( value = "execution(* com.example.SenderEmail.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String  methodName = joinPoint.getSignature().getName() ;
        String className = joinPoint.getTarget().getClass().getName() ;
        LOGGER.error(" Exception from AOP : From method : ' {} ' in class : ' {} '  , message exception : {}", methodName , className , ex.getMessage());
    }


    /**
     * Logs entry, exit, and execution time for the {@code sendEmail} method in the
     * {@code EmailService} class.

     */
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
