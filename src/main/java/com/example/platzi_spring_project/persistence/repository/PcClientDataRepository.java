package com.example.platzi_spring_project.persistence.repository;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface PcClientDataRepository extends ListCrudRepository<PcClientDataEntity, Integer> {
    // Ordenar por la columna idRegister
    List<PcClientDataEntity> findAllByOrderByIdRegister();

    // Buscar por la columna idRegister
    List<PcClientDataEntity> findAllByIdRegister(Integer idRegister);



    // Ordenar por la columna cdIdentification
    List<PcClientDataEntity> findAllByOrderByCdIdentification();

    // Buscar por la columna cdIdentification
    List<PcClientDataEntity> findAllByCdIdentificationIgnoreCase(String cdIdentification);

    // Buscar por la columna cdIdentification ignorando mayusculas y minusculas
    List<PcClientDataEntity> findAllByCdIdentificationContainingIgnoreCase(String cdIdentification);

    // Limitar la busqueda de registros por cdIdentification
    PcClientDataEntity findFirstByCdIdentification(String cdIdentification);



    // Ordenar por la columna cdNames
    List<PcClientDataEntity> findAllByOrderByCdNames();

    // Buscar por la columna cdNames
    List<PcClientDataEntity> findAllByCdNamesIgnoreCase(String cdNames);

    // Buscar por la columna cdNames ignorando mayusculas y minusculas
    List<PcClientDataEntity> findAllByCdNamesContainingIgnoreCase(String cdNames);

    // Limitar la busqueda de registros por cdNames
    PcClientDataEntity findFirstByCdNames(String cdNames);



    // Ordenar por la columna cdSurnames
    List<PcClientDataEntity> findAllByOrderByCdSurnames();

    // Buscar por la columna cdSurnames
    List<PcClientDataEntity> findAllByCdSurnamesIgnoreCase(String cdSurnames);

    // Buscar por la columna cdSurnames ignorando mayusculas y minusculas
    List<PcClientDataEntity> findAllByCdSurnamesContainingIgnoreCase(String cdSurnames);

    // Limitar la busqueda de registros por cdSurnames
    PcClientDataEntity findFirstByCdSurnames(String cdSurnames);



    // Buscar por fecha de creacion antes
    List<PcClientDataEntity> findAllByAtCreatedDateAfter(LocalDateTime atCreatedDate);

    // Buscar por fecha de creacion antes
    List<PcClientDataEntity> findAllByAtModifiedDateAfter(LocalDateTime atModifiedDate);
}
