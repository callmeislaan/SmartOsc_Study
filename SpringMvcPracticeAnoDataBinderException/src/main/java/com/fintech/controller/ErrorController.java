package com.fintech.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = PersonController.PersonNotFoundException.class)
    public String handle(PersonController.PersonNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
