package com.example.platzi_spring_project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Iniciar configuracion de seguridad

        /*
            and: Conector Union
            crsf: Deshabilitar protección CSRF
            cors(): Habilitar politicas de seguridad
            authorizeHttpRequests: Autorizar peticiones http
            anyRequest: Cualquier peticion
            permitAll: Permitir todas las peticiones
            authenticated: Debe estar autenticado
            httpBasic: Autenticado con http basic

            Permitir unicamente el primer nivel: /api/test
            requestMatchers(HttpMethod.GET, "/api/*").permitAll()

            Permitir todos los niveles: /api/test/user
            requestMatchers(HttpMethod.GET, "/api/**").permitAll()

            Proteger unicamente bajo el prefijo indicado
            requestMatchers(HttpMethod.GET, "/api/test/**").permitAll()

            Denegacion total de consumo para metodos especificos
            GET - POST - PUT - DELETE - ETC
            .requestMatchers(HttpMethod.METHOD).denyAll()
        */

        /*httpSecurity
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            .anyRequest()
            .permitAll();*/
        
        httpSecurity
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
            .requestMatchers(HttpMethod.PUT).denyAll()
            .anyRequest()
            .authenticated().and()
            .httpBasic();
        
        return httpSecurity.build();
    }
}
