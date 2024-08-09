package com.example.senderemail.annotations;


import com.example.senderemail.validation.EmailArrayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = EmailArrayValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStringArray {
    String message() default "Invalid email address in the array";
    String regex() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


