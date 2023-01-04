package com.esercitazione.esercitazionespringboot.repository;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Set<Role> getRoles();
}
