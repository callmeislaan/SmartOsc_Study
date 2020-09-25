package com.fintech.controller;

import com.fintech.entity.User;
import com.fintech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/getLogin")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/403")
    public String get403Page() {
        return "403";
    }

    @GetMapping("/getRegister")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser() {
        userService.saveUser();
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPage() {

        return "admin";
    }
}
