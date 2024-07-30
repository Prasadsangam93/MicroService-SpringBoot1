package com.microservice.Product_FC.repository;

import com.microservice.Product_FC.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Product ,Integer> {
}
