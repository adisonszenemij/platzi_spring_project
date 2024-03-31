package com.example.platzi_spring_project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Iniciar configuracion de seguridad

        // authorizeHttpRequests: Autorizar peticiones http
        // anyRequest: Cualquier peticion
        // permitAll: Permitir todas las peticiones
        /*httpSecurity
            .authorizeHttpRequests()
            .anyRequest()
            .permitAll();*/

        // authorizeHttpRequests: Autorizar peticiones http
        // anyRequest: Cualquier peticion
        // authenticated: Debe estar autenticado
        // and: Conector Union
        // httpBasic: Autenticado con http basic
        httpSecurity
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        return httpSecurity.build();
    }
}
