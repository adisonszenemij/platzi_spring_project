package com.example.platzi_spring_project.persistence.repository.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;

public interface PcClientPhoneQuery extends ListCrudRepository<PcClientPhoneEntity, Integer> {
    // Obtener resultados buscando por la columna cdData
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientPhoneEntity trd" + " " +
            "WHERE trd.cdData = :cd_data"
    )
    List<PcClientPhoneEntity> findByCdData(@Param("cd_data") String cdData);
}
