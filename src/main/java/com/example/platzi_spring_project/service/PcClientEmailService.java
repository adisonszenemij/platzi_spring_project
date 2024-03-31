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

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientEmailRepository;
import com.example.platzi_spring_project.persistence.repository.conjunct.PcClientEmailConjunct;
import com.example.platzi_spring_project.persistence.repository.pagesort.PcClientEmailPageSort;
import com.example.platzi_spring_project.persistence.repository.query.PcClientEmailQuery;
import com.example.platzi_spring_project.service.dto.PcClientEmailDto;

@Service
public class PcClientEmailService {
    private final PcClientEmailRepository pcClientEmailRepository;
    private final PcClientEmailPageSort pcClientEmailPageSort;
    private final PcClientEmailConjunct pcClientEmailConjunct;
    private final PcClientEmailQuery pcClientEmailQuery;

    @Autowired
    public PcClientEmailService(
        PcClientEmailRepository pcClientEmailRepository,
        PcClientEmailPageSort pcClientEmailPageSort,
        PcClientEmailConjunct pcClientEmailConjunct,
        PcClientEmailQuery pcClientEmailQuery
    ) {
        this.pcClientEmailRepository = pcClientEmailRepository;
        this.pcClientEmailPageSort = pcClientEmailPageSort;
        this.pcClientEmailConjunct = pcClientEmailConjunct;
        this.pcClientEmailQuery = pcClientEmailQuery;
    }

    public List<PcClientEmailEntity> getAll() {
        return this.pcClientEmailRepository.findAll();
    }

    public PcClientEmailEntity getById(int idRegister) {
        return this.pcClientEmailRepository.findById(idRegister).orElse(null);
    }


    public List<PcClientEmailEntity> getOrderByColumn(String column) {
        List<PcClientEmailEntity> response = null;
        if ("idRegister".equals(column)) {
            response = this.pcClientEmailRepository.findAllByOrderByIdRegister();
        }
        if ("cdData".equals(column)) {
            response = this.pcClientEmailRepository.findAllByOrderByCdData();
        }
        return response;
    }

    public <T> List<PcClientEmailEntity> getSearchData(String column, T data) {
        List<PcClientEmailEntity> response = null;
        if ("idRegister".equals(column) && data instanceof Integer) {
            response = this.pcClientEmailRepository.findAllByIdRegister((Integer) data);
        }
        if ("cdData".equals(column) && data instanceof String) {
            response = this.pcClientEmailRepository.findAllByCdDataIgnoreCase((String) data);
        }
        return response;
    }

    public List<PcClientEmailEntity> getAtDateCreate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientEmailRepository.findAllByAtCreatedDateAfter(today);
    }

    public List<PcClientEmailEntity> getAtDateUpdate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientEmailRepository.findAllByAtModifiedDateAfter(today);
    }

    public Page<PcClientEmailEntity> pageAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pcClientEmailPageSort.findAll(pageRequest);
    }

    public Page<PcClientEmailEntity> pageSortCol(
        int page, int elements, String sortBy, String sortDir
    ) {
        Sort sortData = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sortData);
        return this.pcClientEmailPageSort.findBy(pageRequest);
    }

    public int natCountAll() {
        return this.pcClientEmailConjunct.countAll();
    }

    public List<PcClientEmailEntity> natIdRegister(String idRegister) {
        return this.pcClientEmailConjunct.findIdRegister(idRegister);
    }

    public List<PcClientEmailEntity> queryCdData(String cdData) {
        return this.pcClientEmailQuery.findByCdData(cdData);
    }

    public PcClientEmailEntity save(PcClientEmailEntity pcClientEmailEntity) {
        return this.pcClientEmailRepository.save(pcClientEmailEntity);
    }

    @Transactional
    public void updateDto(PcClientEmailDto pcClientEmailDto) {
        this.pcClientEmailConjunct.updateDto(pcClientEmailDto);
    }

    public void deleteAll() {
        this.pcClientEmailRepository.deleteAll();
    }

    public void deleteById(int idRegister) {
        this.pcClientEmailRepository.deleteById(idRegister);
    }

    public void deleteByIdAll(List<Integer> ids) {
        for (Integer id : ids) {
            this.pcClientEmailRepository.deleteById(id);
        }
    }

    public boolean existsById(int idRegister) {
        return this.pcClientEmailRepository.existsById(idRegister);
    }
}
