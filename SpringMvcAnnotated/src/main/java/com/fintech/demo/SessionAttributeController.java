package com.fintech.demo;

import com.fintech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/session-attribute")
@SessionAttributes("employee")
public class SessionAttributeController {

    @Autowired
    private Employee employee;

    @GetMapping
    public String getSessionAttributeIndexPage(Model model) {
        model.addAttribute("employee", employee);
        return "session-attribute-index";
    }

    @PostMapping(value = "/employee-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> editEmployeeInfo(
            @SessionAttribute(value = "employee") Employee employee) {
        employee.setId(1234);
        employee.setName("session attribute");
//        return "redirect:/show-info";
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

//    @ResponseBody
//    @PostMapping("/show-info")
//    public ResponseEntity<Employee> showEmployeeInfo(
//            @ModelAttribute("employee") Employee employee) {
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }
}
