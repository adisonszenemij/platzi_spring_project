package com.example.platzi_spring_project.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.platzi_spring_project.persistence.entity.TgUserDataEntity;

public interface TgUserDataRepository extends CrudRepository<TgUserDataEntity, Integer> {

}
