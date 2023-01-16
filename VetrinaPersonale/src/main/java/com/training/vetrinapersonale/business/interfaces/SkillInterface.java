package com.training.vetrinapersonale.business.interfaces;

import com.training.vetrinapersonale.model.Skill;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface SkillInterface {
    List<Skill> getAllSkills()throws DataAccessException;
    Skill getSkillById(Long id);
    void addSkill(Skill skill)throws DataAccessException;
    Skill updateSkill(Skill skill);
    void deleteSkill(Long id);
}