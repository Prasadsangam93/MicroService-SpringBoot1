package com.microservice.User.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDemo {
    @GetMapping("/get")
    public String  getUser(){
        return "this is User!!";
    }
}
