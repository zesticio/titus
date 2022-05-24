package com.zestic.apim.rest.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CreateRouteValidatorImpl.class)
public @interface CreateRouteValidator {

    String message() default "com.zestic.apim.rest.api.validation.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
