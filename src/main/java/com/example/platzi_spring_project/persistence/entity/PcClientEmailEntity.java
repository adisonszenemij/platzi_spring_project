package com.example.platzi_spring_project.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pc_client_email")
@Getter
@Setter
@NoArgsConstructor
public class PcClientEmailEntity extends AuditoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_data", nullable = false, unique = true, length = 255)
    private String cdData;

    // Many: PcClientEmail - One: PcClientData
    //@ManyToOne(fecth = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "pc_client_data",
        referencedColumnName = "id_register",
        insertable = false,
        updatable = false
    )
    //@JsonIgnore
    @OrderBy("id_register ASC")
    //@OrderBy("id_register DESC")
    private PcClientDataEntity pcClientData;

    @Override
    public String toString() {
        return "PcClientEmailEntity{" +
            "idRegister=" + idRegister +
            ", cdData='" + cdData + '\'' +
            ", pcClientData=" + pcClientData +
            '}';
    }
}
