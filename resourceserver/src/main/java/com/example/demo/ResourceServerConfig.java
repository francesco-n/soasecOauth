package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/articles/**")
                .authorizeHttpRequests()
                .requestMatchers("/articles/**").hasAuthority("SCOPE_user.read")
                .and().csrf().disable()

                .oauth2ResourceServer(server -> server
                        .jwt(Customizer.withDefaults()));
        		
		return http.build();
	}
}
