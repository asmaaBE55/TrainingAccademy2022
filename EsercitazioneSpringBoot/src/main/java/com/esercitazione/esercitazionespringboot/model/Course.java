package com.esercitazione.esercitazionespringboot.model;


import jakarta.persistence.*;


@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_course")
    private String name_course;
    @Column(name = "description")
    private String description;

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

