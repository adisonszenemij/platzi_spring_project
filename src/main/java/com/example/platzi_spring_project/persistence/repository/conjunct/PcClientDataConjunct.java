package com.example.platzi_spring_project.persistence.repository.conjunct;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.service.dto.PcClientDataDto;

public interface PcClientDataConjunct extends ListCrudRepository<PcClientDataEntity, Integer> {
    // Obtener el conteo de registros de la tabla
    @Query(
        nativeQuery = true,
        value = "SELECT COUNT(*) FROM pc_client_data"
    )
    int countAll();

    // Obtener el conteo de registros de la tabla
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM pc_client_data" + " " +
            "WHERE id_register = :idRegister"
    )
    List<PcClientDataEntity> findIdRegister(
        @Param("idRegister") String idRegister
    );

    @Query(
        nativeQuery = true,
        value = "UPDATE pc_client_data" + " " +
            "SET cd_address = :cdAddress" + " " +
                ", cd_identification = :cdIdentification" + " " +
                ", cd_names = :cdNames" + " " +
                ", cd_surnames = :cdSurnames" + " " +
            "WHERE id_register = :idRegister"
    )
    void updateData(
        @Param("idRegister") int idRegister,
        @Param("cdAddress") String cdAddress,
        @Param("cdIdentification") String cdIdentification,
        @Param("cdNames") String cdNames,
        @Param("cdSurnames") String cdSurnames
    );

    @Modifying
    @Query(
        nativeQuery = true,
        value = "UPDATE pc_client_data" + " " +
            "SET cd_address = :#{#newDto.cdAddress}" +
                ", cd_identification = :#{#newDto.cdIdentification}" +
                ", cd_names = :#{#newDto.cdNames}" +
                ", cd_surnames = :#{#newDto.cdSurnames}" + " " +
            "WHERE id_register = :#{#newDto.idRegister}"
    )
    void updateDto(@Param("newDto") PcClientDataDto newDto);
}
