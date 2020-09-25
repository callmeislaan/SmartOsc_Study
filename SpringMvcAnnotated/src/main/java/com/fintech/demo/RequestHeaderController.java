package com.fintech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/request-header")
public class RequestHeaderController {
    @GetMapping
    @ResponseBody
    public String getRequestHeader(
            @RequestHeader(value = "Accept-Encoding") String encoding,
            @RequestHeader(value = "Accept-Language") String language,
            @RequestHeader(value = "Accept") String accept){
        return "encoding: " + encoding + "- language: " + language
                + " - accept: " + accept;
    }
}
