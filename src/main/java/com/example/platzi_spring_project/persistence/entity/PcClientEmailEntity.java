package com.example.platzi_spring_project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pc_client_email")
@Getter
@Setter
@NoArgsConstructor
public class PcClientEmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_email", nullable = false, unique = false, length = 255)
    private String cdEmail;
}
