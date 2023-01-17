package com.training.vetrinapersonale.business.impl;

import com.training.vetrinapersonale.business.interfaces.CategoryInterface;
import com.training.vetrinapersonale.model.Category;
import com.training.vetrinapersonale.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryInterface {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() throws DataAccessException {
        return categoryRepository.findAll();
    }
}
