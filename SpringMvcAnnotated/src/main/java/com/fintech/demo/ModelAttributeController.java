package com.fintech.demo;

import com.fintech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/model-attribute")
public class ModelAttributeController {

    @Autowired
    private Employee employee;

    @GetMapping
    @ModelAttribute(value = "employee")
    public String getModelAttributeIndexPage(Model model) {
        model.addAttribute(employee);
        return "model-attribute-index";
    }

    @PostMapping(value = "/employee-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> showEmployeeInfo(
            @ModelAttribute(value = "employee") Employee employee) {
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
