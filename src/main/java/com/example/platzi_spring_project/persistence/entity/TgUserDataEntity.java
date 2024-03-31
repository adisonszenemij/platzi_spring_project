package com.example.platzi_spring_project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tg_user_data")
@Getter
@Setter
@NoArgsConstructor
public class TgUserDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_email", nullable = false, unique = true, length = 255)
    private String cdEmail;

    @Column(name = "cd_login", nullable = false, unique = true, length = 255)
    private String cdLogin;

    @Column(name = "cd_password", nullable = false, unique = false, length = 255)
    private String cdPassword;
}
