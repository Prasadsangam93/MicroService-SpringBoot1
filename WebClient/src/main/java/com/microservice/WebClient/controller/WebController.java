package com.microservice.WebClient.controller;

import com.microservice.WebClient.enity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
public class WebController {

    private WebClient webClient;

    public WebController() {
        this.webClient = WebClient.create("http://localhost:8083");


    }

    //non blocking mono
    @GetMapping("/WebAllProducts")
    public Mono<String> webAllProducts() {
        return webClient.get()
                .uri("/getAllProducts")
                .retrieve()
                .bodyToMono(String.class);
    }

    //non blocking flux
    @GetMapping("/prodName")
    public Flux<String> prodName() {
        return webClient.get()
                .uri("/getName")
                .retrieve()
                .bodyToFlux(String.class);


    }

    //same as restTemplate
    @GetMapping("/RestAllProducts")
    public String restAllProducts() {
        return webClient.get()
                .uri("/getAllProducts")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    @PostMapping("postProduct")
    public Mono<Product> postProduct(@RequestBody Product product){
        return webClient.post()
                .uri("/createProduct")
                .body(Mono.just(product),Product.class)
                .retrieve()
                .bodyToMono(Product.class);

}
    @GetMapping("getAllProducts")
    public Flux<ArrayList> getAllProducts(){
        return webClient.get()
                .uri("/getListofProducts")
                .retrieve()
                .bodyToFlux(ArrayList.class);
    }
}