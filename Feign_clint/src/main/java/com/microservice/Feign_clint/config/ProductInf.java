package com.microservice.Feign_clint.config;

import com.microservice.Feign_clint.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ProductAPI",url="http://localhost:8083")
public interface ProductInf {
    @GetMapping("getAllProducts")
    public String getProduct();
    @GetMapping("/getName")
    public  String getName();
    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product );
    @GetMapping("/getListofProducts")
    public List<Product> getListofProduct();

}
