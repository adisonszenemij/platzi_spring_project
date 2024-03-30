package com.example.platzi_spring_project.controller;

import com.example.platzi_spring_project.persistence.entity.ApPizzaEntity;
import com.example.platzi_spring_project.service.ApPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/apPizza")
public class ApPizzaController {
    private final ApPizzaService apPizzaService;

    @Autowired
    public ApPizzaController(ApPizzaService apPizzaService) {
        this.apPizzaService = apPizzaService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ApPizzaEntity>> getAll() {
        return ResponseEntity.ok(this.apPizzaService.getAll());
    }

    @GetMapping(value = "/get/byId/{idRegister}")
    public ResponseEntity<ApPizzaEntity> getById(@PathVariable int idRegister) {
        return ResponseEntity.ok(this.apPizzaService.getById(idRegister));
    }
}
