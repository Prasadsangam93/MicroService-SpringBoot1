package com.microservice.Product_FC.Controller;

import com.microservice.Product_FC.entity.Product;
import com.microservice.Product_FC.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/getAllProducts")
    public String getProduct() {
        return "Mobile \nIphone \nLaptop";
    }

    @GetMapping("/getName")
    public String getName() {
        return " i am product microservice";
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }


    @GetMapping("/getListofProducts")
    public List<Product> getListofProduct(){
        return productRepo.findAll();
    }


}
