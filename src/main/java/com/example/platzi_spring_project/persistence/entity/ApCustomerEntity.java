package com.example.platzi_spring_project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ap_customer")
@Getter
@Setter
public class ApCustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_name", nullable = false, unique = false, length = 255)
    private String cdName;

    @Column(name = "cd_email", nullable = false, unique = false, length = 255)
    private String cdEmail;

    @Column(name = "cd_phone", nullable = false, unique = false, length = 255)
    private String cdPhone;
}
