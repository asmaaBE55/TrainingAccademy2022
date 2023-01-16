package com.training.vetrinapersonale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill")
public class Skill extends BaseEntity {
    private String name;
    private String description;
    private String category;
}