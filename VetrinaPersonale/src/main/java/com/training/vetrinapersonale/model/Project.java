package com.training.vetrinapersonale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project extends BaseEntity {
    private String nome;
    private String descrizione;
    @ManyToMany(mappedBy = "projects")
    private List<Developer> developers = new ArrayList<>();
}