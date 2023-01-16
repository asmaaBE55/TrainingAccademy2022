package com.training.vetrinapersonale.controller;

import com.training.vetrinapersonale.business.interfaces.SkillInterface;
import com.training.vetrinapersonale.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
   public ModelAndView insertSkill(@RequestParam String description, @RequestParam String name, @RequestParam String category){
        Skill skill= new Skill();
        skill.setName(name);
        skill.setDescription(description);
        skill.setCategory(category);
        skillInterface.addSkill(skill);
        return new ModelAndView("/jsp/addSkill.jsp","operation",true);
    }

  }