package com.training.vetrinapersonale.business.impl;

import com.training.vetrinapersonale.business.interfaces.ProjectInterface;
import com.training.vetrinapersonale.model.Project;
import com.training.vetrinapersonale.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImpl implements ProjectInterface {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void addProject(Project project) throws DataAccessException {
        projectRepository.save(project);
    }
}
