package com.training.vetrinapersonale.controller;

import com.training.vetrinapersonale.business.interfaces.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    @Autowired
    private CategoryInterface categoryInterface;

}
