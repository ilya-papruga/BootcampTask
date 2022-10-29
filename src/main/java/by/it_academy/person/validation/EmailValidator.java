package by.it_academy.person.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(email)) {
            context.buildConstraintViolationWithTemplate( "must not be null" )
                    .addConstraintViolation().disableDefaultConstraintViolation();;
            return false;
        }
        if(email.matches("^(?=.{6,50}$)([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)$")) {
            return true;
        }
        context.buildConstraintViolationWithTemplate( "email must be 6-50 characters long" )
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}

