package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.User;
import com.practice.crudproduct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("/find/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public User findByUserName(@PathVariable String userName) {
        return userService.findByUserName(userName);
    }
}