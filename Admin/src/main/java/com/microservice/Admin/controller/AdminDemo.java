package com.microservice.Admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminDemo {
    @GetMapping("/get")
    public String getAdmin(){
        return " this is admin!!" ;
    }
}
