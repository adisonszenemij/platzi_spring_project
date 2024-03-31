package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface PcClientPhoneRepository extends ListCrudRepository<PcClientPhoneEntity, Integer> {
    // Ordenar por la columna idRegister
    List<PcClientPhoneEntity> findAllByOrderByIdRegister();

    // Buscar por la columna idRegister
    List<PcClientPhoneEntity> findAllByIdRegister(Integer idRegister);



    // Ordenar por la columna cdData
    List<PcClientPhoneEntity> findAllByOrderByCdData();

    // Buscar por la columna cdData
    List<PcClientPhoneEntity> findAllByCdDataIgnoreCase(String cdData);

    // Buscar por la columna cdData ignorando mayusculas y minusculas
    List<PcClientPhoneEntity> findAllByCdDataContainingIgnoreCase(String cdData);

    // Limitar la busqueda de registros por cdData
    PcClientPhoneEntity findFirstByCdData(String cdData);



    // Buscar por fecha de creacion antes
    List<PcClientPhoneEntity> findAllByAtCreatedDateAfter(LocalDateTime atCreatedDate);

    // Buscar por fecha de creacion antes
    List<PcClientPhoneEntity> findAllByAtModifiedDateAfter(LocalDateTime atModifiedDate);
}
