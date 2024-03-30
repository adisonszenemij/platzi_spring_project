package com.example.platzi_spring_project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pc_client_data")
@Getter
@Setter
@NoArgsConstructor
public class PcClientDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_address", nullable = false, unique = false, length = 255)
    private String cdAddress;

    @Column(name = "cd_names", nullable = false, unique = false, length = 255)
    private String cdNames;

    @Column(name = "cd_surnames", nullable = false, unique = false, length = 255)
    private String cdSurnames;
}
