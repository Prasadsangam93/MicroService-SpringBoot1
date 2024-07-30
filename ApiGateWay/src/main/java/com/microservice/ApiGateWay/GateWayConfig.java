package com.microservice.ApiGateWay;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public  RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(predicateSpec -> predicateSpec.path("/")
                        .uri("http://localhost:8082"))
                .route(admin-> admin.path("/")
                        .uri("http://localhost:8081"))
                .build();
    }

}
