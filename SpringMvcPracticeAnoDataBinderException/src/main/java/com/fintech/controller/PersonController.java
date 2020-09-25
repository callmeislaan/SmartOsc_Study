package com.fintech.controller;


import com.fintech.model.Person;
import com.fintech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping("/add-person")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @GetMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return service.getPerson(Long.valueOf(id));
    }

    public static class PersonNotFoundException extends RuntimeException {
        public PersonNotFoundException(String message) {
            super(message);
        }
    }
}
