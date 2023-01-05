package com.esercitazione.esercitazionespringboot.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "courses_users",
             inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users=new LinkedHashSet<>();
    @OneToMany(mappedBy = "course")
    private List<Exam> exams;
    public Set<User> getUsers(){return users;}

    public void setUsers(Set<User> users){this.users=users;}
}

