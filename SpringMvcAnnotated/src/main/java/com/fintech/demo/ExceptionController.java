package com.fintech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exception")
@Controller
public class ExceptionController {

    @GetMapping
    public String getExceptionIndexPage() {
        int a = 1/0;
        return "exception-index";
    }

}
