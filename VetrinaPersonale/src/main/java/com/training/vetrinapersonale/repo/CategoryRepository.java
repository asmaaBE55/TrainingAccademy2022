package com.training.vetrinapersonale.repo;

import com.training.vetrinapersonale.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
