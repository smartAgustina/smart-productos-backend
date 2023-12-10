package com.smart.smartproductospet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authRequest ->
        authRequest.requestMatchers("/auth/**").permitAll()
        .anyRequest().authenticated()
        )
        .formLogin(withDefaults())
        .build();
    }
}
