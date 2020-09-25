package com.fintech.demo;

import com.fintech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request-param")
public class RequestParamDemo {

    @Autowired
    private Employee employee;

    @GetMapping
    public String getRequestParamIndexPage() {
        return "request-param-index";
    }

    @PostMapping("/employee-info")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeInfo(
            @RequestParam(value = "name") String name) {
        employee.setId(1);
        employee.setName(name);
        employee.setContactNumber("1234");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
