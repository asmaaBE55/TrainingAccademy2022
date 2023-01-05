package com.esercitazione.esercitazionespringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
public class Exam{
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private double valuation;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Course getCourse() {
        return this.course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}



