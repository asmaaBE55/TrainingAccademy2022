package com.training.vetrinapersonale.repo;

import com.training.vetrinapersonale.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
   List<Skill> findAll();
}
