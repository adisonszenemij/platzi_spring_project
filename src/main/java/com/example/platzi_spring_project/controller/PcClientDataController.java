package com.example.platzi_spring_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.service.PcClientDataService;
import com.example.platzi_spring_project.service.dto.PcClientDataDto;

@RestController
@RequestMapping(value = "/api/pcClientData")
public class PcClientDataController {
    private final PcClientDataService pcClientDataService;

    @Autowired
    public PcClientDataController(
        PcClientDataService pcClientDataService
    ) {
        this.pcClientDataService = pcClientDataService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<PcClientDataEntity>> getAll() {
        return ResponseEntity.ok(this.pcClientDataService.getAll());
    }

    @GetMapping(value = "/get/byId/{idRegister}")
    public ResponseEntity<PcClientDataEntity> getById(@PathVariable int idRegister) {
        return ResponseEntity.ok(this.pcClientDataService.getById(idRegister));
    }

    @GetMapping(value = "/get/orderBy/{column}")
    public ResponseEntity<List<PcClientDataEntity>> getOrderByColumn(
        @PathVariable String column
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.getOrderByColumn(column)
        );
    }

    @GetMapping(value = "/get/search/data")
    public ResponseEntity<List<PcClientDataEntity>> getSearchData(
        @RequestBody Map<String, String> searchData
    ) {
        String columnName = searchData.keySet().iterator().next();
        String columnValue = searchData.get(columnName);

        return ResponseEntity.ok(
            this.pcClientDataService.getSearchData(columnName, columnValue)
        );
    }

    @GetMapping(value = "/get/at/date/create")
    public ResponseEntity<List<PcClientDataEntity>> getAtDateCreate() {
        return ResponseEntity.ok(
            this.pcClientDataService.getAtDateCreate()
        );
    }

    @GetMapping(value = "/get/at/date/update")
    public ResponseEntity<List<PcClientDataEntity>> getAtDateUpdate() {
        return ResponseEntity.ok(
            this.pcClientDataService.getAtDateUpdate()
        );
    }

    @GetMapping(value = "/page/all")
    public ResponseEntity<Page<PcClientDataEntity>> pageAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int elements
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.pageAll(page, elements)
        );
    }

    @GetMapping(value = "/page/sort")
    public ResponseEntity<Page<PcClientDataEntity>> pageSortCol(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int elements,
        @RequestParam(defaultValue = "idRegister") String sortBy,
        @RequestParam(defaultValue = "ASC") String sortDir
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.pageSortCol(
                page, elements, sortBy, sortDir
            )
        );
    }

    @GetMapping(value = "/nat/idRegister/{idRegister}")
    public ResponseEntity<List<PcClientDataEntity>> natIdRegister(
        @PathVariable String idRegister
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.natIdRegister(idRegister)
        );
    }

    @GetMapping(value = "/query/cdIdentification/{cdIdentification}")
    public ResponseEntity<PcClientDataEntity> queryCdIdentification(
        @PathVariable String cdIdentification
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.queryCdIdentification(cdIdentification)
        );
    }

    @GetMapping(value = "/query/cdNames/{cdNames}")
    public ResponseEntity<PcClientDataEntity> queryCdNames(
        @PathVariable String cdNames
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.queryCdNames(cdNames)
        );
    }

    @GetMapping(value = "/query/cdSurnames/{cdSurnames}")
    public ResponseEntity<PcClientDataEntity> queryCdSurnames(
        @PathVariable String cdSurnames
    ) {
        return ResponseEntity.ok(
            this.pcClientDataService.queryCdSurnames(cdSurnames)
        );
    }

    @PostMapping(value = "/post/save/multi")
    public ResponseEntity<List<PcClientDataEntity>> saveMulti(
        @RequestBody List<PcClientDataEntity> pcClientDataEntities
    ) {
        List<PcClientDataEntity> savedEntities = new ArrayList<>();
        for (PcClientDataEntity entity : pcClientDataEntities) {
            if (entity.getIdRegister() == null ||
                !this.pcClientDataService.existsById(
                    entity.getIdRegister()
                )
            ) {
                savedEntities.add(this.pcClientDataService.save(entity));
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok(savedEntities);
    }

    @PostMapping(value = "/insert/register")
    public ResponseEntity<PcClientDataEntity> insertRegister(
        @RequestBody PcClientDataEntity pcClientDataEntity
    ) {
        // Si el id del registro es nulo o si el registro no existe
        if (pcClientDataEntity.getIdRegister() == null ||
            !this.pcClientDataService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(
                this.pcClientDataService.save(
                    pcClientDataEntity
                )
            );
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update/register")
    public ResponseEntity<PcClientDataEntity> updateRegister(
        @RequestBody PcClientDataEntity pcClientDataEntity
    ) {
        // Si el id del registro no es nulo o si el registro existe
        if (pcClientDataEntity.getIdRegister() != null &&
            this.pcClientDataService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(
                this.pcClientDataService.save(
                    pcClientDataEntity
                )
            );
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update/dto")
    public ResponseEntity<Void> updateDto(
        @RequestBody PcClientDataDto pcClientDataDto
    ) {
        if (this.pcClientDataService.existsById(
                pcClientDataDto.getIdRegister()
            )
        ) {
            this.pcClientDataService.updateDto(pcClientDataDto);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<Void> deleteAll() {
        this.pcClientDataService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/byId/{idRegister}")
    public ResponseEntity<?> deleteById(@PathVariable int idRegister) {
        Map<String, String> response = new HashMap<>();
        try {
            var message = "Registro Inexistente";
            if (this.pcClientDataService.existsById(idRegister)) {
                this.pcClientDataService.deleteById(idRegister);
                message = "Registro Eliminado";
            }
            response.put("message", message);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping(value = "/delete/byIdAll/{ids}")
    public ResponseEntity<Void> deleteByIdAll(@PathVariable List<Integer> ids) {
        for (Integer id : ids) {
            if (!this.pcClientDataService.existsById(id)) {
                return ResponseEntity.badRequest().build();
            }
        }

        this.pcClientDataService.deleteByIdAll(ids);
        return ResponseEntity.ok().build();
    }
}
