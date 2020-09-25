package com.fintech.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionProcess {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String loadNotFoundPage(NoHandlerFoundException ex) {
        return " Not Found";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e) {
        return e.toString();
    }
}
