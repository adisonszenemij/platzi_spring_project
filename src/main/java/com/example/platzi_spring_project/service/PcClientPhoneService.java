package com.example.platzi_spring_project.service;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcClientPhoneService {
    private final PcClientPhoneRepository pcClientPhoneRepository;

    @Autowired
    public PcClientPhoneService(PcClientPhoneRepository pcClientPhoneRepository) {
        this.pcClientPhoneRepository = pcClientPhoneRepository;
    }

    public List<PcClientPhoneEntity> getAll() {
        return this.pcClientPhoneRepository.findAll();
    }

    public PcClientPhoneEntity getById(int idRegister) {
        return this.pcClientPhoneRepository.findById(idRegister).orElse(null);
    }
}
