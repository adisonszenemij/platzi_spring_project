package com.example.platzi_spring_project.persistence.repository.conjunct;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import com.example.platzi_spring_project.service.dto.PcClientPhoneDto;

public interface PcClientPhoneConjunct extends ListCrudRepository<PcClientPhoneEntity, Integer> {
    // Obtener el conteo de registros de la tabla
    @Query(
        nativeQuery = true,
        value = "SELECT COUNT(*) FROM pc_client_phone"
    )
    int countAll();

    // Obtener el conteo de registros de la tabla
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM pc_client_phone" + " " +
            "WHERE id_register = :idRegister"
    )
    List<PcClientPhoneEntity> findIdRegister(
        @Param("idRegister") String idRegister
    );

    @Query(
        nativeQuery = true,
        value = "UPDATE pc_client_phone" + " " +
            "SET cd_data = :cdData" + " " +
                ", pc_client_data = :pcClientData" + " " +
            "WHERE id_register = :idRegister"
    )
    void updateData(
        @Param("idRegister") int idRegister,
        @Param("cdData") String cdData,
        @Param("pcClientData") String pcClientData
    );

    @Modifying
    @Query(
        nativeQuery = true,
        value = "UPDATE pc_client_phone" + " " +
            "SET cd_data = :#{#newDto.cdAddress}" +
                ", pc_client_data = :#{#newDto.cdIdentification}" +
            "WHERE id_register = :#{#newDto.idRegister}"
    )
    void updateDto(@Param("newDto") PcClientPhoneDto newDto);
}
