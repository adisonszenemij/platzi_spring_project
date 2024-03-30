package com.example.platzi_spring_project.service;

import com.example.platzi_spring_project.persistence.entity.ApPizzaEntity;
import com.example.platzi_spring_project.persistence.repository.ApPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApPizzaService {
    private final ApPizzaRepository apPizzaRepository;

    @Autowired
    public ApPizzaService(ApPizzaRepository apPizzaRepository) {
        this.apPizzaRepository = apPizzaRepository;
    }

    public List<ApPizzaEntity> getAll() {
        return this.apPizzaRepository.findAll();
    }

    public ApPizzaEntity getById(int idRgister) {
        return this.apPizzaRepository.findById(idRgister).orElse(null);
    }
}
