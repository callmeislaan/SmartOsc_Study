package com.fintech.demo;

import com.fintech.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/request-body")
public class RequestBodyController {

    @GetMapping
    public String getRequestBodyIndexPage() {
        return "request-body-index";
    }

    @PostMapping("/plus")
    @ResponseBody
    public ResponseEntity<Employee> doPlus(
            @RequestBody Employee employee) {
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
