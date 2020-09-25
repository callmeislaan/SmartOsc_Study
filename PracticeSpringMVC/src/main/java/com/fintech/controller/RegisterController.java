package com.fintech.controller;

import com.fintech.model.Person;
import com.fintech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    Person person;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addRegister(@ModelAttribute("person") Person person, ModelMap model) {
        model.addAttribute("person", personService.add(person));
        return "person-view";
    }

}
