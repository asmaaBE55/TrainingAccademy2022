package com.training.vetrinapersonale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project extends BaseEntity {
    private String nome;
    private String descrizione;
}