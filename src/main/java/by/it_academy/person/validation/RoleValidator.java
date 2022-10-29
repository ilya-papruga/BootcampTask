package by.it_academy.person.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<Role, String> {

    @Override
    public void initialize(Role role) {
    }

    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(role)) {
            context.buildConstraintViolationWithTemplate( "must not be null" )
                    .addConstraintViolation().disableDefaultConstraintViolation();;
            return false;
        }
        if(role.matches("Administrator|Sale User|Customer User|Secure API User")) {
            return true;
        }
        context.buildConstraintViolationWithTemplate( "invalid role, correct values: Administrator, Sale User, Customer User, Secure API User." )
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}

