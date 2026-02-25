package com.azzedine.brikoli.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())                                            
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                        .requestMatchers("/api/user/register","/api/user/login").permitAll()
                        .requestMatchers("/api/user/userAuthenticated").hasRole("CLIENT")
                        .requestMatchers("/uploads/**").permitAll()
                        .requestMatchers("/api/mission/create").hasRole("CLIENT")
                        .requestMatchers("/api/mission/user").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.GET, "/api/mission/all").hasRole("CLIENT") // for porfessional and admin not client
                        .requestMatchers(HttpMethod.GET, "/api/category/all").hasRole("CLIENT") // for porfessional and admin and client
                        .requestMatchers("/api/mission/posted").hasRole("CLIENT")
                        .requestMatchers("/api/mission/en_cours").hasRole("CLIENT")
                        .requestMatchers("/api/mission/completed").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.PUT,"/api/mission/*").hasRole("CLIENT")
                        .requestMatchers(HttpMethod.GET, "/api/mission/*").hasRole("CLIENT") 
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
