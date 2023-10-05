package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AuthorizationserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationserverApplication.class, args);
	}
	
	
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailsManager () {
//		var one = User.withDefaultPasswordEncoder().roles("admin").username("amministratore").password("adminpassword").build();
//		var two = User.withDefaultPasswordEncoder().roles("user").username("utente").password("password").build();
//		return new InMemoryUserDetailsManager(one, two);
		
//	}
}