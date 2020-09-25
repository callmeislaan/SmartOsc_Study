package com.fintech.exception;

import com.fintech.validation.MyValidation;
import com.fintech.validation.MyValidationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class ExceptionTranslator {

    @Autowired
    MessageSource messageSource;

    // khong co requestbody
//    @ExceptionHandler(BindException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public List<MyValidation> haValidationError(BindException e) {
//        return MyValidationBuilder.fromBindingErrors(e.getBindingResult());
//    }

    // co requestbody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<MyValidation> haValidationError(MethodArgumentNotValidException e) {
        return MyValidationBuilder.fromBindingErrors(e.getBindingResult());
    }

    // for path variable or request parameter
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public List<MyValidation> haValidationError(ConstraintViolationException e) {
//        return MyValidationBuilder.fromBindingErrors(e);
//    }

//     for path variable or request parameter
    @ExceptionHandler(StatusException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<MyValidation> haValidationError(StatusException e) {
        return MyValidationBuilder.fromBindingErrors(e);
    }
}
