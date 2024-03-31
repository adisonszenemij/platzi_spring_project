package com.example.platzi_spring_project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
        */

        /*
            Permitir unicamente el primer nivel: /api/test
            requestMatchers(HttpMethod.GET, "/api/*").permitAll()

            Permitir todos los niveles: /api/test/user
            requestMatchers(HttpMethod.GET, "/api/**").permitAll()

            Proteger unicamente bajo el prefijo indicado
            requestMatchers(HttpMethod.GET, "/api/test/**").permitAll()

            GET - POST - PUT - DELETE - ETC
            Denegacion total de consumo para metodos especificos
            .requestMatchers(HttpMethod.METHOD).denyAll()

            GET - POST - PUT - DELETE - ETC
            hasAnyRole: Permitir acceso a los diferentes metodos segun varios roles
            .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "CUSTOMER")

            GET - POST - PUT - DELETE - ETC
            hasRole: Permitir acceso a los diferentes metodos segun un rol especificado
            .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "CUSTOMER")

            hasRole: Permitir acceso a todos los metodos segun un rol especificado
            .requestMatchers("/api/**").hasRole("ADMIN")
        */
        
        httpSecurity
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            
            //.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
            //.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "CUSTOMER")
            .requestMatchers(HttpMethod.GET, "/api/pcClientData/**").hasAnyRole("ADMIN", "CUSTOMER")
            //.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
            .requestMatchers("/api/pcClientData/get/all").hasAnyAuthority("random_order")
            //.requestMatchers("/api/**").hasRole("ADMIN")
            //.requestMatchers(HttpMethod.PUT).denyAll()
            
            .anyRequest()
            .authenticated().and()
            .httpBasic();
        
        return httpSecurity.build();
    }

    /*@Bean
    public UserDetailsService memoryUsers() {
        UserDetails root = User.builder()
            .username("root")
            .password(passwordEncoder().encode("root"))
            .roles("ADMIN")
            .build();

        UserDetails customer = User.builder()
                .username("customer")
                .password(passwordEncoder().encode("customer"))
                .roles("CUSTOMER")
                .build();

        return new InMemoryUserDetailsManager(root, customer);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
