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

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import com.example.platzi_spring_project.service.PcClientPhoneService;
import com.example.platzi_spring_project.service.dto.PcClientPhoneDto;

@RestController
@RequestMapping(value = "/api/pcClientPhone")
public class PcClientPhoneController {
    private final PcClientPhoneService pcClientPhoneService;

    @Autowired
    public PcClientPhoneController(
        PcClientPhoneService pcClientPhoneService
    ) {
        this.pcClientPhoneService = pcClientPhoneService;
    }

    // Obtener todos los registros
    @GetMapping(value = "/get/all")
    public ResponseEntity<List<PcClientPhoneEntity>> getAll() {
        return ResponseEntity.ok(this.pcClientPhoneService.getAll());
    }

    // Path Variable - Obtener un registro especifico
    @GetMapping(value = "/get/byId/{idRegister}")
    public ResponseEntity<PcClientPhoneEntity> getById(@PathVariable int idRegister) {
        return ResponseEntity.ok(this.pcClientPhoneService.getById(idRegister));
    }

    // Path Varabile - Ordenar los registros por columna
    @GetMapping(value = "/get/orderBy/{column}")
    public ResponseEntity<List<PcClientPhoneEntity>> getOrderByColumn(
        @PathVariable String column
    ) {
        return ResponseEntity.ok(
            this.pcClientPhoneService.getOrderByColumn(column)
        );
    }

    // Request Body - Obtener registros segun busqueda
    @GetMapping(value = "/get/search/data")
    public ResponseEntity<List<PcClientPhoneEntity>> getSearchData(
        @RequestBody Map<String, String> searchData
    ) {
        String columnName = searchData.keySet().iterator().next();
        String columnValue = searchData.get(columnName);

        return ResponseEntity.ok(
            this.pcClientPhoneService.getSearchData(columnName, columnValue)
        );
    }

    // Obtener registros con fecha de creacion actual
    @GetMapping(value = "/get/at/date/cr")
    public ResponseEntity<List<PcClientPhoneEntity>> getAtDateCreate() {
        return ResponseEntity.ok(
            this.pcClientPhoneService.getAtDateCreate()
        );
    }

    // Obtener registros con fecha de actualizacion actual
    @GetMapping(value = "/get/at/date/up")
    public ResponseEntity<List<PcClientPhoneEntity>> getAtDateUpdate() {
        return ResponseEntity.ok(
            this.pcClientPhoneService.getAtDateUpdate()
        );
    }

    // Obtener todos los registros con paginacion
    @GetMapping(value = "/page/all")
    public ResponseEntity<Page<PcClientPhoneEntity>> pageAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int rows
    ) {
        return ResponseEntity.ok(
            this.pcClientPhoneService.pageAll(page, rows)
        );
    }

    // Obtener todos los registros con paginacion y ordenacion
    @GetMapping(value = "/page/sort")
    public ResponseEntity<Page<PcClientPhoneEntity>> pageSortCol(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int rows,
        @RequestParam(defaultValue = "idRegister") String sortBy,
        @RequestParam(defaultValue = "ASC") String sortDir
    ) {
        return ResponseEntity.ok(
            this.pcClientPhoneService.pageSortCol(
                page, rows, sortBy, sortDir
            )
        );
    }

    // Path Variable - Obtener un registro especifico
    @GetMapping(value = "/nat/idRegister/{idRegister}")
    public ResponseEntity<List<PcClientPhoneEntity>> natIdRegister(
        @PathVariable String idRegister
    ) {
        return ResponseEntity.ok(
            this.pcClientPhoneService.natIdRegister(idRegister)
        );
    }

    // Path Variable - Obtener un registro especifico
    @GetMapping(value = "/query/cdData/{cdData}")
    public ResponseEntity<List<PcClientPhoneEntity>> queryCdData(
        @PathVariable String cdData
    ) {
        return ResponseEntity.ok(
            this.pcClientPhoneService.queryCdData(cdData)
        );
    }

    // Request Body - Almacenar varios registros
    @PostMapping(value = "/insert/multi")
    public ResponseEntity<List<PcClientPhoneEntity>> saveMulti(
        @RequestBody List<PcClientPhoneEntity> pcClientDataEntities
    ) {
        List<PcClientPhoneEntity> savedEntities = new ArrayList<>();
        for (PcClientPhoneEntity entity : pcClientDataEntities) {
            if (entity.getIdRegister() == null ||
                !this.pcClientPhoneService.existsById(
                    entity.getIdRegister()
                )
            ) {
                savedEntities.add(this.pcClientPhoneService.save(entity));
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok(savedEntities);
    }

    // Request Body - Almacenar un registro
    @PostMapping(value = "/insert/register")
    public ResponseEntity<PcClientPhoneEntity> insertRegister(
        @RequestBody PcClientPhoneEntity pcClientDataEntity
    ) {
        // Si el id del registro es nulo o si el registro no existe
        if (pcClientDataEntity.getIdRegister() == null ||
            !this.pcClientPhoneService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(
                this.pcClientPhoneService.save(
                    pcClientDataEntity
                )
            );
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }

    // Request Body - Actualizar un registro
    @PutMapping(value = "/update/register")
    public ResponseEntity<PcClientPhoneEntity> updateRegister(
        @RequestBody PcClientPhoneEntity pcClientDataEntity
    ) {
        // Si el id del registro no es nulo o si el registro existe
        if (pcClientDataEntity.getIdRegister() != null &&
            this.pcClientPhoneService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(
                this.pcClientPhoneService.save(
                    pcClientDataEntity
                )
            );
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }

    // Request Body - Actualizar un registro
    @PutMapping(value = "/update/dto")
    public ResponseEntity<Void> updateDto(
        @RequestBody PcClientPhoneDto pcClientDataDto
    ) {
        if (this.pcClientPhoneService.existsById(
                pcClientDataDto.getIdRegister()
            )
        ) {
            this.pcClientPhoneService.updateDto(pcClientDataDto);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    // Eliminar todos los registros
    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<Void> deleteAll() {
        this.pcClientPhoneService.deleteAll();
        return ResponseEntity.ok().build();
    }

    // Eliminar un registros especifico
    @DeleteMapping(value = "/delete/byId/{idRegister}")
    public ResponseEntity<?> deleteById(@PathVariable int idRegister) {
        Map<String, String> response = new HashMap<>();
        try {
            var message = "Registro Inexistente";
            if (this.pcClientPhoneService.existsById(idRegister)) {
                this.pcClientPhoneService.deleteById(idRegister);
                message = "Registro Eliminado";
            }
            response.put("message", message);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Eliminar varios registros especificos
    @DeleteMapping(value = "/delete/byIdAll/{ids}")
    public ResponseEntity<Void> deleteByIdAll(@PathVariable List<Integer> ids) {
        for (Integer id : ids) {
            if (this.pcClientPhoneService.existsById(id)) {
                this.pcClientPhoneService.deleteByIdAll(ids);
                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.badRequest().build();
    }
}
