package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PcClientPhoneRepository extends ListCrudRepository<PcClientPhoneEntity, Integer> {
    
}
