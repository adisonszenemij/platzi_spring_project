package com.example.platzi_spring_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.service.PcClientDataService;

@RestController
@RequestMapping(value = "/api/pcClientData")
public class PcClientDataController {
    private final PcClientDataService pcClientDataService;

    @Autowired
    public PcClientDataController(PcClientDataService pcClientDataService) {
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

    @PostMapping(value = "/insert/register")
    public ResponseEntity<PcClientDataEntity> insert(
        @RequestBody PcClientDataEntity pcClientDataEntity
    ) {
        // Si el id del registro es nulo o si el registro no existe
        if (pcClientDataEntity.getIdRegister() == null ||
            !this.pcClientDataService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(this.pcClientDataService.save(pcClientDataEntity));
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/update/register")
    public ResponseEntity<PcClientDataEntity> update(
        @RequestBody PcClientDataEntity pcClientDataEntity
    ) {
        // Si el id del registro no es nulo o si el registro existe
        if (pcClientDataEntity.getIdRegister() != null ||
            this.pcClientDataService.existsById(
                pcClientDataEntity.getIdRegister()
            )
        ) {
            return ResponseEntity.ok(this.pcClientDataService.save(pcClientDataEntity));
        }
        // No se procese la peticion a construir
        return ResponseEntity.badRequest().build();
    }
}
