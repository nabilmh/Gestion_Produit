package com.example.demo.controller;

import com.example.demo.Role;
import com.example.demo.model.MyUserPrincipal;
import com.example.demo.model.User;
import com.example.demo.service.MyUserDetailsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.demo.Role.SuperUser;

public class SuperUserSecurityConfig{

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private MyUserPrincipal myUserPrincipal;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


       http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/users/**","/agencies/**").hasAuthority("SuperUser")
                        .requestMatchers("/products/**").hasAuthority("User")
                        .anyRequest().authenticated()
                )
               .userDetailsService(myUserDetailsService)

                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )

                .logout(logout -> logout
                        .permitAll());
        return http.build();

        /*http
                .authorizeHttpRequests((authorize) -> {
                    authorize
                            .requestMatchers("/users/**").hasAuthority("SuperUser")
                            .requestMatchers("/agencies/**").hasAuthority("SuperUser")
                            .requestMatchers("/products/**").hasAuthority("User")
                            .anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();*/
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserDetailsService userDetailsService;






   /*@Bean
    public UserDetailsService userDetailsService(){





        UserDetails nabil = User.builder()
                .username("nabil")
                .password(passwordEncoder.encode("nabil"))
                .roles("User")
                .build();


        return new InMemoryUserDetailsManager(nabil);
    }*/









}
