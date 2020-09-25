package com.fintech.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    public String handle(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "404");
        map.put("reason", "not found");
        map.put("a", "aot a");
        map.put("b", "not b");
        request.setAttribute("mapError", map);
        return "error";
    }
}
