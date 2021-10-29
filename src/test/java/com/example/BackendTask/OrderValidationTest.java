package com.example.BackendTask;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.example.BackendTask.Models.Order;
import com.example.BackendTask.Models.User;
import org.junit.Before;
import org.junit.Test;

public class OrderValidationTest {

    private Validator validator;
    private Order order;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        order = new Order(1,1,1,"BUY", new User(1,"test"));
    }

    @Test
    public void invalidPriceShouldFailValidation() {
        order.setPrice(-10);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validPriceShouldSucceedValidation() {
        order.setPrice(10);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void invalidQuantityShouldFailValidation() {
        order.setQuantity(-10);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validQuantityShouldSucceedValidation() {
        order.setQuantity(10);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void invalidTypeShouldFailValidation() {
        order.setType("");
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validTypeBuyShouldSucceedValidation() {
        order.setType("BUY");
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void validTypeSELLShouldSucceedValidation() {
        order.setType("SELL");
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        assertTrue(violations.isEmpty());
    }
}
