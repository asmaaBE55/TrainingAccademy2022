package com.training.vetrinapersonale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project extends BaseEntity {
    private String nome;
    private String descrizione;
    @ManyToMany
    private Set<Category> categories;

    @ManyToMany
    private Set<Skill> skills;
}