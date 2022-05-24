package com.zestic.apim.rest.api.validation;

import com.zestic.springboot.common.validation.Validatable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateRouteValidatorImpl implements ConstraintValidator<CreateRouteValidator, Validatable> {

    @Override
    public boolean isValid(Validatable route, ConstraintValidatorContext context) {
        return route.isValid();
    }
}
