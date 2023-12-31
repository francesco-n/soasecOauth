package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        		.csrf(csrf -> csrf.disable())
        		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        		.authorizeHttpRequests(auth -> {
        			auth.requestMatchers("/","/error").permitAll();
        			auth.requestMatchers(HttpMethod.GET,"/notes").permitAll();
        			auth.requestMatchers(HttpMethod.GET,"/profile/notes").hasAuthority("SCOPE_leggiNote");
        			auth.requestMatchers(HttpMethod.POST,"/profile/notes").hasAuthority("SCOPE_scriviNote");
        			auth.requestMatchers(HttpMethod.GET,"/profile/notes/**").hasAuthority("SCOPE_leggiNote");
        			auth.requestMatchers(HttpMethod.PUT,"/profile/notes/**").hasAuthority("SCOPE_scriviNote");
        			auth.requestMatchers(HttpMethod.DELETE,"/profile/notes/**").hasAuthority("SCOPE_scriviNote");
        		}) 
        		.oauth2ResourceServer(server -> server
                        .jwt(Customizer.withDefaults()))
        		
        	.build();
	}
}
