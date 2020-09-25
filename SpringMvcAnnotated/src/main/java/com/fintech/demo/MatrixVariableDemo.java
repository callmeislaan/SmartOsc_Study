package com.fintech.demo;

import com.fintech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/employeeContacts")
public class MatrixVariableDemo {

    @Autowired
    private Employee employee;

//    @GetMapping(value = "/{contactNumber}")
//    @ResponseBody
//    public ResponseEntity<List<Employee>> getEmployeeByContactNumber(
//            @MatrixVariable(value = "contactNumber") String contactNumber) {
//        List<Employee> employees = new ArrayList<>();
//        employee.setId(1);
//        employee.setName("htp");
//        employee.setContactNumber(contactNumber);
//        employees.add(employee);
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping(value = "/{name}")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByEmployeeName(
            @PathVariable(value = "name") String name,
            @MatrixVariable(value = "contactNumber") String contactNumber) {
        List<Employee> employeeList = new ArrayList<>();
        employee.setName(name);
        employee.setId(1);
        employee.setContactNumber(contactNumber);
        employeeList.add(employee);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
