package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@SpringBootApplication
public class OauthclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthclientApplication.class, args);
	}
	
	@Bean
	RouteLocator gateway (RouteLocatorBuilder rlb) {
		return rlb
				.routes()
				.route( rs-> rs
						.path("/profile/notes")
						.filters(GatewayFilterSpec::tokenRelay)
						.uri("http://localhost:8081"))
				.route( r -> r
						.path("/notes")
						.uri("http://localhost:8081"))
				.build();
	}
	
}
