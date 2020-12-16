package com.codegym.exam.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
}
