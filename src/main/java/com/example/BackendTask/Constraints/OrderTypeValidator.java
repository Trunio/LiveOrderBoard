package com.example.BackendTask.Constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderTypeValidator implements ConstraintValidator<OrderType, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals("BUY") || s.equals("SELL");
    }
}
