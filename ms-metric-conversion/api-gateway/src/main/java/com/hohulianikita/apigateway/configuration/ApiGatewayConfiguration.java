package com.hohulianikita.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/v1/metric-exchange/**")
                        .uri("lb://metric-exchange"))
                .route(p -> p.path("/v1/metric-conversion/**")
                        .uri("lb://metric-conversion"))
                .route(p -> p.path("/v1/metric-conversion-feign/**")
                        .uri("lb://metric-conversion"))
                .build();
    }

}
