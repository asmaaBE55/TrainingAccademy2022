package com.training.vetrinapersonale.business.interfaces;

import com.training.vetrinapersonale.model.Category;
import com.training.vetrinapersonale.model.Skill;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryInterface {
    List<Category> getAllCategories() throws DataAccessException;

    void addCategory(Category category)throws DataAccessException;
}
