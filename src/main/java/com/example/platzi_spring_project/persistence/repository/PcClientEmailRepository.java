package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface PcClientEmailRepository extends ListCrudRepository<PcClientEmailEntity, Integer> {
    // Ordenar por la columna idRegister
    List<PcClientEmailEntity> findAllByOrderByIdRegister();

    // Buscar por la columna idRegister
    List<PcClientEmailEntity> findAllByIdRegister(Integer idRegister);



    // Ordenar por la columna cdData
    List<PcClientEmailEntity> findAllByOrderByCdData();

    // Buscar por la columna cdData
    List<PcClientEmailEntity> findAllByCdDataIgnoreCase(String cdData);

    // Buscar por la columna cdData ignorando mayusculas y minusculas
    List<PcClientEmailEntity> findAllByCdDataContainingIgnoreCase(String cdData);

    // Limitar la busqueda de registros por cdData
    PcClientEmailEntity findFirstByCdData(String cdData);



    // Buscar por fecha de creacion antes
    List<PcClientEmailEntity> findAllByAtCreatedDateAfter(LocalDateTime atCreatedDate);

    // Buscar por fecha de creacion antes
    List<PcClientEmailEntity> findAllByAtModifiedDateAfter(LocalDateTime atModifiedDate);
}
