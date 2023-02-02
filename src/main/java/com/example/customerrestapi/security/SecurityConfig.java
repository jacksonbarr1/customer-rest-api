package com.example.customerrestapi.security;

import com.example.customerrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/register")
                        .permitAll().anyRequest().authenticated())
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }
}
