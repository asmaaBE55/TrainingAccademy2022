package com.training.vetrinapersonale.controller;

import com.training.vetrinapersonale.business.interfaces.CategoryInterface;
import com.training.vetrinapersonale.business.interfaces.SkillInterface;
import com.training.vetrinapersonale.model.Category;
import com.training.vetrinapersonale.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SkillController {

    @Autowired
    private SkillInterface skillInterface;

    @GetMapping(path = {"/", "/home"})
    public ModelAndView home() {
        List<Skill> skills = skillInterface.getAllSkills();
        return new ModelAndView("/jsp/home.jsp", "Info", skills);
    }

    @GetMapping("addSkill")
    public ModelAndView addSkill() {
        return new ModelAndView("/jsp/addSkill.jsp");
    }

    @PostMapping("/addSkill")
    public ModelAndView addSkillForm(@RequestParam String name, @RequestParam String description, @RequestParam Category category) {
        Skill skills= new Skill();
        skills.setName(name);
        skills.setDescription(description);
        skills.setCategory(category);
        skillInterface.addSkill(skills);
        return new ModelAndView("/jsp/addSkill.jsp", "operation", true);
    }

}