package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PcClientDataRepository extends ListCrudRepository<PcClientDataEntity, Integer> {
    
}
