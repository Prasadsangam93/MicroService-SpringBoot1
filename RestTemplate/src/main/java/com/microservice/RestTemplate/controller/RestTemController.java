package com.microservice.RestTemplate.controller;

import com.microservice.RestTemplate.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTemController {
    @Lazy
    @Autowired
    private RestTemplate rest;
    @GetMapping("/getRest")
    public String getAllProd(){
        return rest.getForObject("http://localhost:8083/getAllProducts",String.class);
    }
    @PostMapping("postProduct")
    public Product postProduct(@RequestBody Product product){
        return rest.postForObject("http://localhost:8084/createProduct",product,Product.class );
    }
    @SuppressWarnings("uncheked")
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return rest.getForObject("http://localhost:8084/getListofProducts", ArrayList.class);
    }
    @Bean
    private RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
