package com.example.platzi_spring_project.controller;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;
import com.example.platzi_spring_project.service.PcClientPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pcClientPhone")
public class PcClientPhoneController {
    private final PcClientPhoneService pcClientPhoneService;

    @Autowired
    public PcClientPhoneController(PcClientPhoneService pcClientPhoneService) {
        this.pcClientPhoneService = pcClientPhoneService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<PcClientPhoneEntity>> getAll() {
        return ResponseEntity.ok(this.pcClientPhoneService.getAll());
    }

    @GetMapping(value = "/get/byId/{idRegister}")
    public ResponseEntity<PcClientPhoneEntity> getById(@PathVariable int idRegister) {
        return ResponseEntity.ok(this.pcClientPhoneService.getById(idRegister));
    }
}
