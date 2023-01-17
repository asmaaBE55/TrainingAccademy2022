package com.training.vetrinapersonale.controller;

import com.training.vetrinapersonale.business.interfaces.CategoryInterface;
import com.training.vetrinapersonale.model.Category;
import com.training.vetrinapersonale.model.Project;
import com.training.vetrinapersonale.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class CategoryController {
    @Autowired
    private CategoryInterface categoryInterface;
    @GetMapping("/admin/addCategory")
    public ModelAndView addCategory() {
        return new ModelAndView("/jsp/addCategory.jsp");
    }

    @PostMapping("/admin/addCategory")
    public ModelAndView insertCategory(@RequestParam String name, @RequestParam Project project,@RequestParam Skill skill) {
        Category category= new Category();
        category.setName(name);
        category.setProjects((Set<Project>) project);
        category.setSkills((Set<Skill>) skill);
        categoryInterface.addCategory(category);
        return new ModelAndView("/jsp/addCategory.jsp", "operation", true);
    }
}
