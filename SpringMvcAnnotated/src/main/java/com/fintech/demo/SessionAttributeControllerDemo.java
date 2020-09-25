package com.fintech.demo;

import com.fintech.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("pet")
public class SessionAttributeControllerDemo {

    @Autowired
    Pet pet;

//    @GetMapping("/")
//    public String onSetup(@ModelAttribute(name = "pet") Pet pet) {
//        return "index";
//    }

    @GetMapping("/editPet")
    @ResponseBody
    public String handle(Pet pet, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "error";
        }
        pet.setOwnerId(1L);
        pet.setPetId(1L);
        status.setComplete();
        return "success";
    }
}

