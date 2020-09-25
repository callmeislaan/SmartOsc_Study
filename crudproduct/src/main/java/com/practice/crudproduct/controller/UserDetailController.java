package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.UserDetail;
import com.practice.crudproduct.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetails")
public class UserDetailController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public UserDetail save(@RequestBody UserDetail userDetail) {
        return userDetailsService.save(userDetail);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody UserDetail userDetail) {
        userDetailsService.delete(userDetail);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetail findById(@PathVariable String id) {
        return userDetailsService.findById(Long.parseLong(id));
    }
}
