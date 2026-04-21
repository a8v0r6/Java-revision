package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

    @GetMapping("/users")
    public String getUsers() {
        System.out.println("UserController.getUsers");
        return "Success";
    }
}
