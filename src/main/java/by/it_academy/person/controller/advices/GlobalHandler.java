package by.it_academy.person.controller.advices;

import by.it_academy.person.dto.error.FieldError;
import by.it_academy.person.dto.error.MultiplyError;
import by.it_academy.person.dto.error.SingleError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalHandler {

    private static final Logger logger = LogManager.getLogger();

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<SingleError> handle(IllegalArgumentException e) {

        List<SingleError> errorResponseList = new ArrayList<>();
        errorResponseList.add(new SingleError(e.getMessage()));
        logger.error(e.getMessage());
        return errorResponseList;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<SingleError> handle() {

        String message = "the request contains an invalid set of fields";
        List<SingleError> errorResponseList = new ArrayList<>();
        errorResponseList.add(new SingleError(message));
        logger.error(message);
        return errorResponseList;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiplyError handle(ConstraintViolationException e) {
        List<FieldError> fieldError = new ArrayList<>();

        String field = null;

        for (ConstraintViolation constraintViolation : e.getConstraintViolations()) {

            for (Path.Node node : constraintViolation.getPropertyPath()) {
                field = node.getName();
            }
            logger.error(field + " " + constraintViolation.getMessage());
            fieldError.add(new FieldError(constraintViolation.getMessage(), field));
        }
        return new MultiplyError(fieldError);
    }

}
