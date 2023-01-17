package com.training.vetrinapersonale.controller;

import com.training.vetrinapersonale.business.interfaces.ProjectInterface;
import com.training.vetrinapersonale.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {
    @Autowired
    private ProjectInterface projectInterface;

    @GetMapping("/admin/addProject")
    public ModelAndView addProject() {
        return new ModelAndView("/jsp/addProject.jsp");
    }

    @PostMapping("/admin/addProject")
    public ModelAndView insertProject(@RequestParam String descrizione, @RequestParam String nome) {
        Project project = new Project();
        project.setNome(nome);
        project.setDescrizione(descrizione);
        projectInterface.addProject(project);
        return new ModelAndView("/jsp/addProject.jsp", "operation", true);
    }
}
