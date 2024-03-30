package com.example.platzi_spring_project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ap_pizza")
@Getter
@Setter
@NoArgsConstructor
public class ApPizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Column(name = "cd_name", nullable = false, unique = false, length = 255)
    private String cdName;

    @Column(name = "cd_description", nullable = false, unique = false, length = 255)
    private String cdDescription;

    @Column(name = "cd_price", nullable = false, unique = false, columnDefinition = "Decimal(5,2)")
    private Double cdPrice;

    @Column(name = "cd_vegetarian", nullable = false, unique = false, columnDefinition = "TINYINT")
    private Boolean cdVegetarian;

    @Column(name = "cd_vegan", nullable = false, unique = false, columnDefinition = "TINYINT")
    private Boolean cdVegan;

    @Column(name = "cd_available", nullable = false, unique = false, columnDefinition = "TINYINT")
    private Boolean cdAvailable;
}
