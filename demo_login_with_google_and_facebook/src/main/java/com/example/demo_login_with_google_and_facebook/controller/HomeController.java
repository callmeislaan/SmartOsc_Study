package com.example.demo_login_with_google_and_facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("home")
    @ResponseBody
    public Principal googleLogin(Principal principal) {
        return principal;
    }
}
