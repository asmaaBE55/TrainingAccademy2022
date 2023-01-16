package com.training.vetrinapersonale.business.interfaces;

import com.training.vetrinapersonale.model.Project;
import com.training.vetrinapersonale.model.Skill;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProjectInterface {
    List<Project> getAllProjects() throws DataAccessException;
    void addProject(Project project) throws DataAccessException;
}
