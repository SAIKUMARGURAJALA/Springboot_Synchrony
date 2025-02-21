package dev.synchrony.user.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/**").permitAll()  // Allow all requests without authentication
                        .anyRequest().authenticated()  // Authenticate all other requests (optional)
                )
                .csrf(csrf -> csrf.disable())  // Disabling CSRF protection for REST API
                .build(); // Build and return SecurityFilterChain
    }
}
