package com.fintech.controller;

import com.fintech.model.Person;
import com.fintech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String homeController() {
        return "index";
    }

    @RequestMapping("/getPerson")
    public String personController(@RequestParam("id") Long id, Model model) {
        Person person = personService.getById(id);
        model.addAttribute("person", person);
        return "person-view";
    }
}
