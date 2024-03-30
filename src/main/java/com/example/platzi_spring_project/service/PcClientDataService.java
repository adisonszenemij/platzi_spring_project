package com.example.platzi_spring_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientDataRepository;

@Service
public class PcClientDataService {
    private final PcClientDataRepository pcClientDataRepository;

    @Autowired
    public PcClientDataService(PcClientDataRepository pcClientDataRepository) {
        this.pcClientDataRepository = pcClientDataRepository;
    }

    public List<PcClientDataEntity> getAll() {
        return this.pcClientDataRepository.findAll();
    }

    public PcClientDataEntity getById(int idRegister) {
        return this.pcClientDataRepository.findById(idRegister).orElse(null);
    }

    public PcClientDataEntity save(PcClientDataEntity pcClientDataEntity) {
        return this.pcClientDataRepository.save(pcClientDataEntity);
    }

    public boolean existsById(int idRegister) {
        return this.pcClientDataRepository.existsById(idRegister);
    }
}
