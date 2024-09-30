package com.example.senderemail.aspect;


import com.example.senderemail.exception.EmailValidationException;
import com.example.senderemail.utils.APIResponse;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletionException;

import static com.example.senderemail.constant.AOPConstant.EXECUTION_TIME_MESSAGE;


@Aspect
@Component
public class AroundAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(AroundAspects.class);


    @Around("execution(* com.example.senderemail.service.*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.nanoTime();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getSimpleName();

        Object retVal = pjp.proceed();

        long endTime = System.nanoTime();
        double durationInMilliseconds = (double) (endTime - startTime) / 1_000_000;

        LOGGER.info(EXECUTION_TIME_MESSAGE, methodName, className, durationInMilliseconds);

        return retVal;
    }





}

