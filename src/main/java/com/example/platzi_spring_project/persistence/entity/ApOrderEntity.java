package com.example.platzi_spring_project.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ap_order")
@Getter
@Setter
@NoArgsConstructor
public class ApOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_date", nullable = false, unique = false, columnDefinition = "DATETIME")
    private LocalDateTime cdDate;

    @Column(name = "cd_total", nullable = false, unique = false, columnDefinition = "Decimal(6,2)")
    private Double cdTotal;

    @Column(name = "cd_method", nullable = false, unique = false, columnDefinition = "CHAR(1)")
    private String cdMethod;

    @Column(name = "cd_additional", nullable = false, unique = false, length = 255)
    private String cdAdditional;
}
