package com.example.demo.controller;

import com.example.demo.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SuperUserSecurityConfig{

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers("/").permitAll()
                .requestMatchers("/users/**", "/agence/**").hasRole("SuperUser")
                .requestMatchers("/products").hasRole("User")
                .anyRequest().authenticated();

        return http.build();
    }


}
