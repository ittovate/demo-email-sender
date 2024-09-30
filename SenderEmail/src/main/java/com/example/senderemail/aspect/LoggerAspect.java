package com.example.senderemail.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.example.senderemail.constant.AOPConstant.*;

/**
 * This class is an Aspect component used for logging method executions and exceptions in the application.
 * It uses Aspect-Oriented Programming (AOP) .
 * <p>
 * The {@code LoggerAspect} class contains two main aspects:
 * <ul>
 *    1-  <li>{@code logAfterThrowing}: Logs information about exceptions thrown by methods in the
 *     {@code com.example.senderemail.service} package.</li>
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
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.example.senderemail.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        LOGGER.error(AFTER_THROWING_LOGGER_MESSAGE,
                methodName, className, ex.getMessage());
    }


    /**
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution( * com.example.senderemail.service.EmailService.validateEmailAndSend(..) )")
    public void loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        LOGGER.info(AROUND_VALIDATING_EMAILS_MESSAGE, methodName, className);

        joinPoint.proceed();

        LOGGER.info(AROUND_VALIDATING_EMAILS_SUCCESS_MESSAGE);

    }


}
