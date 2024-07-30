package com.microservice.CircuitBreaker2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CircuitBreaker2Application {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreaker2Application.class, args);
	}
	@GetMapping("/getMirco2")
	public String getMirco(){
		return "circuitBreaker2 ";
	}



}
