package com.fintech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cookie-value")
public class CookieValueController {
    @GetMapping
    @ResponseBody
    public String getCookieValue(
            @CookieValue(value = "JSESSIONID") String jsessionid,
            @CookieValue(value = "mycookie") String myCookie) {
        return "j session id: " + jsessionid + " - my cookie: " + myCookie;
    }
}
