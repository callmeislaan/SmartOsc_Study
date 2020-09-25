package com.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {

    @RequestMapping("/input")
    public String goInput() {
        return "input";
    }

    @RequestMapping(value = "/show-input", method = RequestMethod.POST)
    public String showInput(@RequestParam("id") int id, @RequestParam("name") String name,  Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "show-input";
    }
}
