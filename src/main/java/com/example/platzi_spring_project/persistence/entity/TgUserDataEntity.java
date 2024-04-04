package com.example.platzi_spring_project.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tg_user_data")
@Getter
@Setter
@NoArgsConstructor
public class TgUserDataEntity extends AuditoryEntity implements Serializable {
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

    // Many: TgUserData - One: TgRoleData
    //@ManyToOne(fecth = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "tg_role_data",
        referencedColumnName = "id_register",
        insertable = false,
        updatable = false
    )
    //@JsonIgnore
    @OrderBy("id_register ASC")
    //@OrderBy("id_register DESC")
    private TgRoleDataEntity tgRoleData;

    // Many: TgUserData - One: TgUserState
    //@ManyToOne(fecth = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "tg_user_state",
        referencedColumnName = "id_register",
        insertable = false,
        updatable = false
    )
    //@JsonIgnore
    @OrderBy("id_register ASC")
    //@OrderBy("id_register DESC")
    private TgUserStateEntity tgUserState;

    // Imprimir Atributos
    @Override
    public String toString() {
        return "TgUserDataEntity{" +
            "idRegister=" + idRegister +
            ", cdEmail='" + cdEmail + '\'' +
            ", cdLogin='" + cdLogin + '\'' +
            ", cdPassword='" + cdPassword + '\'' +
            ", tgRoleData=" + tgRoleData +
            ", tgUserState=" + tgUserState +
            '}';
    }
}
