package com.example.platzi_spring_project.controller;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;
import com.example.platzi_spring_project.service.PcClientEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pcClientEmail")
public class PcClientEmailController {
    private final PcClientEmailService pcClientEmailService;

    @Autowired
    public PcClientEmailController(PcClientEmailService pcClientEmailService) {
        this.pcClientEmailService = pcClientEmailService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<PcClientEmailEntity>> getAll() {
        return ResponseEntity.ok(this.pcClientEmailService.getAll());
    }

    @GetMapping(value = "/get/byId/{idRegister}")
    public ResponseEntity<PcClientEmailEntity> getById(@PathVariable int idRegister) {
        return ResponseEntity.ok(this.pcClientEmailService.getById(idRegister));
    }
}
