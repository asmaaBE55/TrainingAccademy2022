package com.esercitazione.esercitazionespringboot.repository;

import com.esercitazione.esercitazionespringboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
