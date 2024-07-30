package com.microservice.Feign_clint.controller;

import com.microservice.Feign_clint.config.ProductInf;
import com.microservice.Feign_clint.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    ProductInf productInf;

    @GetMapping("/product")
    public String productAll() {
        return productInf.getProduct();

    }

    @GetMapping("/findName")
    public String findName() {
        return productInf.getName();

    }

    @GetMapping("/getListofProducts")
    public List<Product> getListofProduct() {
        return productInf.getListofProduct();
    }
    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product ){
        return productInf.createProduct(product);

    }
}