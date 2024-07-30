package com.microservice.CircuitBreaker.controller;

import com.microservice.CircuitBreaker.entity.User;
import com.microservice.CircuitBreaker.repository.CircuitRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CircuitBreakController {
    @Lazy
    @Autowired
    private RestTemplate rest;
    @Bean
    private  RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired


    private CircuitRepo circuitRepo;
    @PostMapping("/postuser")
    public User postUserData(@RequestBody User user){
        return circuitRepo.save(user);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return circuitRepo.findAll();
    }
    @GetMapping("/get")
    @CircuitBreaker(name="getdata",fallbackMethod="fallGetData")
    public String getData() throws Exception{
        //throw new Exception();
       // return " I am circuitBreakerMicro";
        return rest.getForObject("http://localhost:8088/getMirco1",String.class);
    }
    public  String fallGetData(Exception e){
        //return " I am  FallBackMethod";
        return rest.getForObject("http://localhost:8089/getMirco2",String.class);
    }


}
