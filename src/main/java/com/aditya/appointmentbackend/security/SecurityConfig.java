package com.aditya.appointmentbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers(
                                "/health",
                                "/users/signupOtpRequest",
                                "/auth/**",
                                "/business/request-signup",
                                "/business/verify-otp"
                        ).permitAll()
                        // All other endpoints require authentication
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable()); // disable default login page

        return http.build();
    }
}
