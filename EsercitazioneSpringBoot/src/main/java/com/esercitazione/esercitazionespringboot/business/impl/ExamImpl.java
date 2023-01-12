package com.esercitazione.esercitazionespringboot.business.impl;

import com.esercitazione.esercitazionespringboot.business.services.ExamInterface;
import com.esercitazione.esercitazionespringboot.model.Exam;
import com.esercitazione.esercitazionespringboot.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExamImpl implements ExamInterface {

    @Autowired
    ExamRepository examRepository;

    @Override
    public Exam save(Exam exam) {
        examRepository.save(exam);
        return exam;
    }

    @Override
    public Set<Exam> findAllExams() {
        return (Set<Exam>) examRepository.findAll();
    }

    @Override
    public Exam findExamByID(long id) {
        return examRepository.getReferenceById(id);
    }

    @Override
    public void deleteRoleByID(long id) {
        examRepository.deleteById(id);
    }

    @Override
    public Set<Exam> findExamByEvalutation(int vote) {
        return examRepository.getExamByEvalutation(vote);
    }
}