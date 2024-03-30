package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PcClientEmailRepository extends ListCrudRepository<PcClientEmailEntity, Integer> {
    
}
