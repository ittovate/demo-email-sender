package com.example.senderemail.aspect;

import com.example.senderemail.utils.EmailValidations;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.senderemail.constant.AOPConstant.AFTER_RETURNING_MESSAGE;

@Aspect
@Component
public class AfterAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfterAspects.class);

    private final EmailValidations emailValidator;

    public AfterAspects(EmailValidations emailValidator) {
        this.emailValidator = emailValidator;
    }


    @AfterReturning("execution (* com.example.senderemail.*.*.*(..))")
    public void afterReturning(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        LOGGER.info(AFTER_RETURNING_MESSAGE, methodName, className);
    }


}
