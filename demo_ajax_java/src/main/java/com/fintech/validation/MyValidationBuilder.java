package com.fintech.validation;

import com.fintech.exception.StatusException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MyValidationBuilder {

    public static List<MyValidation> fromBindingErrors(Errors errors) {
        List<MyValidation> myValidations = new ArrayList<>();
        for (ObjectError objectError :
                errors.getAllErrors()) {
            MyValidation myValidation = new MyValidation();
            myValidation.setPropertyPath(objectError.getCodes()[0]);
            myValidation.setMessage(objectError.getDefaultMessage());
            myValidations.add(myValidation);
        }
        return myValidations;
    }

//    public static List<MyValidation> fromBindingErrors(ConstraintViolationException e) {
//        List<MyValidation> myValidations = new ArrayList<>();
//        for (ConstraintViolation<?> objectError :
//                e.getConstraintViolations()) {
//            MyValidation myValidation = new MyValidation();
//            myValidation.setPropertyPath(objectError.getPropertyPath().toString());
//            myValidation.setMessage(objectError.getMessage());
//            myValidations.add(myValidation);
//        }
//        return myValidations;
//    }

    public static List<MyValidation> fromBindingErrors(StatusException e) {
        List<MyValidation> myValidations = new ArrayList<>();
        MyValidation myValidation = new MyValidation();
        myValidation.setPropertyPath("Error.PersonDTO.status");
        myValidation.setMessage(e.getMessage());
        myValidations.add(myValidation);
        return myValidations;
    }
}
