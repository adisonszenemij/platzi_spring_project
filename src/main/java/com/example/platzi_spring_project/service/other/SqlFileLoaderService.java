package com.example.platzi_spring_project.service.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class SqlFileLoaderService {
private final JdbcTemplate jdbcTemplate;

    public SqlFileLoaderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void loadSqlFiles() {
        try {
            ClassPathResource[] resources = {
                new ClassPathResource("sql/delete/pc_client_data.sql"),
                new ClassPathResource("sql/delete/pc_client_email.sql"),
                new ClassPathResource("sql/delete/pc_client_phone.sql"),
                
                new ClassPathResource("sql/alter/pc_client_data.sql"),
                new ClassPathResource("sql/alter/pc_client_email.sql"),
                new ClassPathResource("sql/alter/pc_client_phone.sql"),

                new ClassPathResource("sql/insert/pc_client_data.sql"),
                new ClassPathResource("sql/insert/pc_client_email.sql"),
                new ClassPathResource("sql/insert/pc_client_phone.sql"),
            };

            for (ClassPathResource resource : resources) {
                if (!resource.exists()) {
                    throw new IOException("File not found: " + resource.getPath());
                }

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                    String sql = reader.lines().collect(Collectors.joining("\n"));
                    jdbcTemplate.execute(sql);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading SQL files", e);
        }
    }
}
