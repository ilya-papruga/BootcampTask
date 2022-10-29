package by.it_academy.person.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatronymicValidator implements ConstraintValidator<Patronymic, String> {

    @Override
    public void initialize(Patronymic patronymic) {
    }

    @Override
    public boolean isValid(String patronymic, ConstraintValidatorContext context) {

        if(StringUtils.isEmpty(patronymic)) {
            context.buildConstraintViolationWithTemplate( "must not be null" )
                    .addConstraintViolation().disableDefaultConstraintViolation();;
            return false;
        }
        if(patronymic.matches("^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            return true;
        }
        context.buildConstraintViolationWithTemplate( "patronymic must be 40 characters long, latin letters only" )
                .addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}

