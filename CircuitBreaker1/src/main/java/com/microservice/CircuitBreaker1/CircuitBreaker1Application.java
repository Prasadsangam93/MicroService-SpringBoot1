package com.microservice.CircuitBreaker1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CircuitBreaker1Application {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreaker1Application.class, args);
	}
	@GetMapping("/getMirco1")
	public String getMirco(){
		return "circuitBreaker1";
	}


}
