package com.example.senderemail.aspect;


import com.example.senderemail.model.Email;
import com.example.senderemail.utils.EmailValidations;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfterAspects.class);

    @Autowired
    private final EmailValidations emailValidator;

    public AfterAspects(EmailValidations emailValidator) {
        this.emailValidator = emailValidator;
    }



    @AfterReturning("execution (* com.example.senderemail.*.*.*(..))")
    public void afterReturning(JoinPoint jp) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        LOGGER.info(" After Returning: From method : {} in class : {} ", methodName , className );
    }






}
