package com.example.platzi_spring_project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientPhoneRepository;
import com.example.platzi_spring_project.persistence.repository.conjunct.PcClientPhoneConjunct;
import com.example.platzi_spring_project.persistence.repository.pagesort.PcClientPhonePageSort;
import com.example.platzi_spring_project.persistence.repository.query.PcClientPhoneQuery;
import com.example.platzi_spring_project.service.dto.PcClientPhoneDto;

@Service
public class PcClientPhoneService {
    private final PcClientPhoneRepository pcClientPhoneRepository;
    private final PcClientPhonePageSort pcClientPhonePageSort;
    private final PcClientPhoneConjunct pcClientPhoneConjunct;
    private final PcClientPhoneQuery pcClientPhoneQuery;

    @Autowired
    public PcClientPhoneService(
        PcClientPhoneRepository pcClientPhoneRepository,
        PcClientPhonePageSort pcClientPhonePageSort,
        PcClientPhoneConjunct pcClientPhoneConjunct,
        PcClientPhoneQuery pcClientPhoneQuery
    ) {
        this.pcClientPhoneRepository = pcClientPhoneRepository;
        this.pcClientPhonePageSort = pcClientPhonePageSort;
        this.pcClientPhoneConjunct = pcClientPhoneConjunct;
        this.pcClientPhoneQuery = pcClientPhoneQuery;
    }

    public List<PcClientPhoneEntity> getAll() {
        return this.pcClientPhoneRepository.findAll();
    }

    public PcClientPhoneEntity getById(int idRegister) {
        return this.pcClientPhoneRepository.findById(idRegister).orElse(null);
    }


    public List<PcClientPhoneEntity> getOrderByColumn(String column) {
        List<PcClientPhoneEntity> response = null;
        if ("idRegister".equals(column)) {
            response = this.pcClientPhoneRepository.findAllByOrderByIdRegister();
        }
        if ("cdData".equals(column)) {
            response = this.pcClientPhoneRepository.findAllByOrderByCdData();
        }
        return response;
    }

    public <T> List<PcClientPhoneEntity> getSearchData(String column, T data) {
        List<PcClientPhoneEntity> response = null;
        if ("idRegister".equals(column) && data instanceof Integer) {
            response = this.pcClientPhoneRepository.findAllByIdRegister((Integer) data);
        }
        if ("cdData".equals(column) && data instanceof String) {
            response = this.pcClientPhoneRepository.findAllByCdDataIgnoreCase((String) data);
        }
        return response;
    }

    public List<PcClientPhoneEntity> getAtDateCreate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientPhoneRepository.findAllByAtCreatedDateAfter(today);
    }

    public List<PcClientPhoneEntity> getAtDateUpdate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientPhoneRepository.findAllByAtModifiedDateAfter(today);
    }

    public Page<PcClientPhoneEntity> pageAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pcClientPhonePageSort.findAll(pageRequest);
    }

    public Page<PcClientPhoneEntity> pageSortCol(
        int page, int elements, String sortBy, String sortDir
    ) {
        Sort sortData = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sortData);
        return this.pcClientPhonePageSort.findBy(pageRequest);
    }

    public int natCountAll() {
        return this.pcClientPhoneConjunct.countAll();
    }

    public List<PcClientPhoneEntity> natIdRegister(String idRegister) {
        return this.pcClientPhoneConjunct.findIdRegister(idRegister);
    }

    public List<PcClientPhoneEntity> queryCdData(String cdData) {
        return this.pcClientPhoneQuery.findByCdData(cdData);
    }

    public PcClientPhoneEntity save(PcClientPhoneEntity pcClientPhoneEntity) {
        return this.pcClientPhoneRepository.save(pcClientPhoneEntity);
    }

    @Transactional
    public void updateDto(PcClientPhoneDto pcClientPhoneDto) {
        this.pcClientPhoneConjunct.updateDto(pcClientPhoneDto);
    }

    public void deleteAll() {
        this.pcClientPhoneRepository.deleteAll();
    }

    public void deleteById(int idRegister) {
        this.pcClientPhoneRepository.deleteById(idRegister);
    }

    public void deleteByIdAll(List<Integer> ids) {
        for (Integer id : ids) {
            this.pcClientPhoneRepository.deleteById(id);
        }
    }

    public boolean existsById(int idRegister) {
        return this.pcClientPhoneRepository.existsById(idRegister);
    }
}
