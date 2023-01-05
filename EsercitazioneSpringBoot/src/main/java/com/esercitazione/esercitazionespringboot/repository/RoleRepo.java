package com.esercitazione.esercitazionespringboot.repository;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.ERole;
import com.esercitazione.esercitazionespringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
