package by.it_academy.person.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirstNameValidator implements ConstraintValidator<FirstName, String> {

    @Override
    public void initialize(FirstName firstName) {
    }

    @Override
    public boolean isValid(String firstName, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(firstName)) {
            context.buildConstraintViolationWithTemplate( "must not be null" )
                    .addConstraintViolation().disableDefaultConstraintViolation();;
            return false;
        }
        if(firstName.matches("^(?=.{3,20}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            return true;
        }
        context.buildConstraintViolationWithTemplate( "first name must be 3-20 characters long, latin letters only" )
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}

