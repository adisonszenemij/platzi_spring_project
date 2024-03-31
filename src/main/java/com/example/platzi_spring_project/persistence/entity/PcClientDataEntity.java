package com.example.platzi_spring_project.persistence.entity;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.platzi_spring_project.persistence.audit.PcClientDataListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pc_client_data")
@EntityListeners({AuditingEntityListener.class, PcClientDataListener.class})
@Getter
@Setter
@NoArgsConstructor
public class PcClientDataEntity extends AuditoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_address", nullable = false, unique = false, length = 255)
    private String cdAddress;

    @Column(name = "cd_identification", nullable = false, unique = false, length = 255)
    private String cdIdentification;

    @Column(name = "cd_names", nullable = false, unique = false, length = 255)
    private String cdNames;

    @Column(name = "cd_surnames", nullable = false, unique = false, length = 255)
    private String cdSurnames;
}
