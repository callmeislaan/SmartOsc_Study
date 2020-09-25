package com.fintech.controller;

import com.fintech.model.Person;
import com.fintech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    Person person;

    @Autowired
    PersonService service;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("person", person);
        model.addAttribute("StatusName", Person.Status.values());
        return "jsp/index";
    }
}
