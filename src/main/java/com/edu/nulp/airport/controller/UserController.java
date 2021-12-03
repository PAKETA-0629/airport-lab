package com.edu.nulp.airport.controller;

import com.edu.nulp.airport.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return ;
    }
}
