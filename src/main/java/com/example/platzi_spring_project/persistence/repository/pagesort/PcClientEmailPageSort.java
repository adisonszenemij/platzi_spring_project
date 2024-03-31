package com.example.platzi_spring_project.persistence.repository.pagesort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;

public interface PcClientEmailPageSort extends ListPagingAndSortingRepository<PcClientEmailEntity, Integer> {
    // Ordenar datos por columna y retornar n cantidad de registros
    Page<PcClientEmailEntity> findBy(Pageable pageable);
}
