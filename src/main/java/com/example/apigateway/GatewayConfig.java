package com.example.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

        @Autowired
        AuthenticationFilter filter;

        @Bean
        public RouteLocator routes(RouteLocatorBuilder builder) {
                return builder.routes().route("chatbot-service", r -> r.path("/chatbot-service/**")
                                .filters(f -> f.stripPrefix(1)).uri("lb://CHATBOT-SERVICE")).

                                route("consulta-service",
                                                r -> r.path("/consulta-service/**")
                                                                .filters(f -> f.stripPrefix(1).filter(filter))
                                                                .uri("lb://CONSULTA-SERVICE"))
                                .

                                route("ema-service", r -> r.path("/ema-service/**")
                                                .filters(f -> f.stripPrefix(1).filter(filter)).uri("lb://EMA-SERVICE"))
                                .

                                route("inf-service", r -> r.path("/inf-service/**")
                                                .filters(f -> f.stripPrefix(1).filter(filter)).uri("lb://INF-SERVICE"))
                                .

                                route("auth-service", r -> r.path("/auth-service/auth/**")
                                                .filters(f -> f.stripPrefix(1)).uri("lb://INF-SERVICE"))
                                .

                                route("inf-service-noauth", r -> r.path("/inf-service-noauth/*/list/**")
                                                .filters(f -> f.stripPrefix(1)).uri("lb://INF-SERVICE"))
                                .

                                // route("chat-service", r -> r.path("/chat-service/**").filters(f ->
                                // f.stripPrefix(1))
                                // .uri("lb://CONSULTA-SERVICE"))
                                // .

                                build();
        }

}
