package com.training.vetrinapersonale.repo;

import com.training.vetrinapersonale.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> { }

