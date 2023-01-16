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
@Table(name = "skill")
public class Skill extends BaseEntity {
    private String name;
    private String description;
    private String category;
    @ManyToMany(mappedBy = "skills")
    private List<Developer> developers = new ArrayList<>();
}