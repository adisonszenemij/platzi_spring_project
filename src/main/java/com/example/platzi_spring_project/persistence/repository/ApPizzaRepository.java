package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.ApPizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ApPizzaRepository extends ListCrudRepository<ApPizzaEntity, Integer> {
}
