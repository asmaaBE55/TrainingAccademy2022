package com.training.vetrinapersonale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Skill> skills;

    @ManyToMany(mappedBy = "categories")
    private Set<Project> projects;
}