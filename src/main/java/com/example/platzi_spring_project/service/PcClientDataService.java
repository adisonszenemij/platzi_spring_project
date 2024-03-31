package com.example.platzi_spring_project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.persistence.repository.PcClientDataRepository;
import com.example.platzi_spring_project.persistence.repository.conjunct.PcClientDataConjunct;
import com.example.platzi_spring_project.persistence.repository.pagesort.PcClientDataPageSort;
import com.example.platzi_spring_project.persistence.repository.query.PcClientDataQuery;
import com.example.platzi_spring_project.service.dto.PcClientDataDto;

@Service
public class PcClientDataService {
    private final PcClientDataRepository pcClientDataRepository;
    private final PcClientDataPageSort pcClientDataPageSort;
    private final PcClientDataConjunct pcClientDataConjunct;
    private final PcClientDataQuery pcClientDataQuery;

    @Autowired
    public PcClientDataService(
        PcClientDataRepository pcClientDataRepository,
        PcClientDataPageSort pcClientDataPageSort,
        PcClientDataConjunct pcClientDataConjunct,
        PcClientDataQuery pcClientDataQuery
    ) {
        this.pcClientDataRepository = pcClientDataRepository;
        this.pcClientDataPageSort = pcClientDataPageSort;
        this.pcClientDataConjunct = pcClientDataConjunct;
        this.pcClientDataQuery = pcClientDataQuery;
    }

    @Secured("ROLE_ADMIN")
    public List<PcClientDataEntity> getAll() {
        return this.pcClientDataRepository.findAll();
    }

    public PcClientDataEntity getById(int idRegister) {
        return this.pcClientDataRepository.findById(idRegister).orElse(null);
    }


    public List<PcClientDataEntity> getOrderByColumn(String column) {
        List<PcClientDataEntity> response = null;
        if ("idRegister".equals(column)) {
            response = this.pcClientDataRepository.findAllByOrderByIdRegister();
        }
        if ("cdIdentification".equals(column)) {
            response = this.pcClientDataRepository.findAllByOrderByCdIdentification();
        }
        if ("cdNames".equals(column)) {
            response = this.pcClientDataRepository.findAllByOrderByCdNames();
        }
        if ("cdSurnames".equals(column)) {
            response = this.pcClientDataRepository.findAllByOrderByCdSurnames();
        }
        return response;
    }

    public <T> List<PcClientDataEntity> getSearchData(String column, T data) {
        List<PcClientDataEntity> response = null;
        if ("idRegister".equals(column) && data instanceof Integer) {
            response = this.pcClientDataRepository.findAllByIdRegister((Integer) data);
        }
        if ("cdIdentification".equals(column) && data instanceof String) {
            response = this.pcClientDataRepository.findAllByCdIdentificationIgnoreCase((String) data);
        }
        if ("cdNames".equals(column) && data instanceof String) {
            response = this.pcClientDataRepository.findAllByCdNamesIgnoreCase((String) data);
        }
        if ("cdSurnames".equals(column) && data instanceof String) {
            response = this.pcClientDataRepository.findAllByCdSurnamesIgnoreCase((String) data);
        }
        return response;
    }

    public List<PcClientDataEntity> getAtDateCreate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientDataRepository.findAllByAtCreatedDateAfter(today);
    }

    public List<PcClientDataEntity> getAtDateUpdate() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.pcClientDataRepository.findAllByAtModifiedDateAfter(today);
    }

    public Page<PcClientDataEntity> pageAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pcClientDataPageSort.findAll(pageRequest);
    }

    public Page<PcClientDataEntity> pageSortCol(
        int page, int elements, String sortBy, String sortDir
    ) {
        Sort sortData = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sortData);
        return this.pcClientDataPageSort.findBy(pageRequest);
    }

    public int natCountAll() {
        return this.pcClientDataConjunct.countAll();
    }

    public List<PcClientDataEntity> natIdRegister(String idRegister) {
        return this.pcClientDataConjunct.findIdRegister(idRegister);
    }

    public List<PcClientDataEntity> queryCdIdentification(String cdIdentification) {
        return this.pcClientDataQuery.findByCdIdentification(cdIdentification);
    }

    public List<PcClientDataEntity> queryCdNames(String cdNames) {
        return this.pcClientDataQuery.findByCdNames(cdNames);
    }

    public List<PcClientDataEntity> queryCdSurnames(String cdSurnames) {
        return this.pcClientDataQuery.findByCdSurnames(cdSurnames);
    }

    public PcClientDataEntity save(PcClientDataEntity pcClientDataEntity) {
        return this.pcClientDataRepository.save(pcClientDataEntity);
    }

    @Transactional
    public void updateDto(PcClientDataDto pcClientDataDto) {
        this.pcClientDataConjunct.updateDto(pcClientDataDto);
    }

    public void deleteAll() {
        this.pcClientDataRepository.deleteAll();
    }

    public void deleteById(int idRegister) {
        this.pcClientDataRepository.deleteById(idRegister);
    }

    public void deleteByIdAll(List<Integer> ids) {
        for (Integer id : ids) {
            this.pcClientDataRepository.deleteById(id);
        }
    }

    public boolean existsById(int idRegister) {
        return this.pcClientDataRepository.existsById(idRegister);
    }
}
