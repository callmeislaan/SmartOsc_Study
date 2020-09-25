package com.fintech.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Future;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

}
