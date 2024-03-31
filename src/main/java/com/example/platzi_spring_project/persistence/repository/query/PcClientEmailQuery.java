package com.example.platzi_spring_project.persistence.repository.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;

public interface PcClientEmailQuery extends ListCrudRepository<PcClientEmailEntity, Integer> {
    // Obtener resultados buscando por la columna cdData
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientEmailEntity trd" + " " +
            "WHERE trd.cdData = :cd_data"
    )
    PcClientEmailEntity findByCdData(@Param("cd_data") String cdData);
}
