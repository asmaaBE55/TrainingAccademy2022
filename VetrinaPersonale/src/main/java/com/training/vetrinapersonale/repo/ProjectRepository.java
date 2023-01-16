package com.training.vetrinapersonale.repo;

import com.training.vetrinapersonale.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Long> {

}
