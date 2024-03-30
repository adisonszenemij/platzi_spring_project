package com.example.platzi_spring_project.controller;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;
import com.example.platzi_spring_project.service.PcClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
