package com.fintech.demo_rest_unit_test.endpoint;

import com.fintech.demo_rest_unit_test.entity.Person;
import com.fintech.demo_rest_unit_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonEndpoint {

    @Autowired
    PersonService personService;

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }
}
