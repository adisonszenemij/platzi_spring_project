package com.example.platzi_spring_project.persistence.repository.pagesort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;

public interface PcClientPhonePageSort extends ListPagingAndSortingRepository<PcClientPhoneEntity, Integer> {
    // Ordenar datos por columna y retornar n cantidad de registros
    Page<PcClientPhoneEntity> findBy(Pageable pageable);
}
