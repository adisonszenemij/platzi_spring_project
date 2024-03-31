package com.example.platzi_spring_project.persistence.repository.query;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;

public interface PcClientDataQuery extends ListCrudRepository<PcClientDataEntity, Integer> {
    // Obtener resultados buscando por la columna cdAddress
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientDataEntity trd" + " " +
            "WHERE trd.cdAddress = :cd_address"
    )
    List<PcClientDataEntity> findByCdAddress(@Param("cd_address") String cdAddress);
    
    // Obtener resultados buscando por la columna cdIdentification
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientDataEntity trd" + " " +
            "WHERE trd.cdIdentification = :cd_identification"
    )
    List<PcClientDataEntity> findByCdIdentification(@Param("cd_identification") String cdIdentification);
    
    // Obtener resultados buscando por la columna cdNames
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientDataEntity trd" + " " +
            "WHERE trd.cdNames = :cd_names"
    )
    List<PcClientDataEntity> findByCdNames(@Param("cd_names") String cdNames);
    
    // Obtener resultados buscando por la columna cdSurnames
    @Query(
        nativeQuery = false,
        value = "SELECT trd FROM PcClientDataEntity trd" + " " +
            "WHERE trd.cdSurnames = :cd_surnames"
    )
    List<PcClientDataEntity> findByCdSurnames(@Param("cd_surnames") String cdSurnames);
}
