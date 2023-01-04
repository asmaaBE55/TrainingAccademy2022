package com.esercitazione.esercitazionespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @NotBlank
    @Size(max= 20)
    private String username;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles =new LinkedHashSet<>();


    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinTable(name = "courses_users",
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses =new LinkedHashSet<>();

    public Set<Course> getCourses(){return courses;}
    public void setCourses(Set<Course>courses){this.courses=courses;}

   public User(){}

    public User(String username, String email, String password, Set<Course> courses) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.courses = courses;
    }

    public void addRole(Role _role) {
        this.roles.add(_role);
    }
}
