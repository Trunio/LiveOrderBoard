package com.example.BackendTask;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.example.BackendTask.Models.User;
import org.junit.Before;
import org.junit.Test;

public class UserValidationTest {

    private Validator validator;
    private User user;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        user = new User(1,"username");
    }

    @Test
    public void invalidNicknameShouldFailValidation() {
        user.setUsername("");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void validNicknameShouldFailValidation() {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }


}
