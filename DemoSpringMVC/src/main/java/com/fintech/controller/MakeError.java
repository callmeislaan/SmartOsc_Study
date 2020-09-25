package com.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/makeError", method = RequestMethod.POST)
public class MakeError {
    @GetMapping
    public String makeError() {
        double e = 1/0;
        return "index";
    }
}
