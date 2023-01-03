package com.esercitazione.esercitazionespringboot.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "course")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Course {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Getter
    @Setter
    @Column(name = "name_course")
    private String name_course;




    @Getter
    @Setter
    @Column(name = "description")
    private String description;

}

