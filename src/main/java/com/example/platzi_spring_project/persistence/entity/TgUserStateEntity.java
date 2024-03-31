package com.example.platzi_spring_project.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tg_role_data")
@Getter
@Setter
@NoArgsConstructor
public class TgUserStateEntity extends AuditoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_name", nullable = false, unique = true, length = 255)
    private String cdName;
}
