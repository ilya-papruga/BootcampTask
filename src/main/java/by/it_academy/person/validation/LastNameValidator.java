package by.it_academy.person.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LastNameValidator implements ConstraintValidator<LastName, String> {

    @Override
    public void initialize(LastName lastName) {
    }

    @Override
    public boolean isValid(String lastName, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(lastName)) {
            context.buildConstraintViolationWithTemplate( "must not be null" )
                    .addConstraintViolation().disableDefaultConstraintViolation();;
            return false;
        }
        if(lastName.matches("^(?=.{3,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            return true;
        }
        context.buildConstraintViolationWithTemplate( "last name must be 3-40 characters long, latin letters only" )
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}

