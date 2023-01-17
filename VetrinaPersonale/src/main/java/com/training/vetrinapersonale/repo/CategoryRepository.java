package com.training.vetrinapersonale.repo;

import com.training.vetrinapersonale.model.Category;
import com.training.vetrinapersonale.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();

}
