package com.example.platzi_spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PlatziSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziSpringProjectApplication.class, args);
	}

}
