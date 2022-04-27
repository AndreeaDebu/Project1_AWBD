package com.example.Project1_AWBD.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitOfMeasure;

    @OneToOne
    private Ingredient ingredient;

}
