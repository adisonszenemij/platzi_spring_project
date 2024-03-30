package com.example.platzi_spring_project.service;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcClientEmailService {
    private final PcClientEmailRepository pcClientEmailRepository;

    @Autowired
    public PcClientEmailService(PcClientEmailRepository pcClientEmailRepository) {
        this.pcClientEmailRepository = pcClientEmailRepository;
    }

    public List<PcClientEmailEntity> getAll() {
        return this.pcClientEmailRepository.findAll();
    }

    public PcClientEmailEntity getById(int idRegister) {
        return this.pcClientEmailRepository.findById(idRegister).orElse(null);
    }
}
