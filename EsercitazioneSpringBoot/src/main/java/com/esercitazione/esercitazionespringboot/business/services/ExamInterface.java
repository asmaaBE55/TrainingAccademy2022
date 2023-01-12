package com.esercitazione.esercitazionespringboot.business.services;

import com.esercitazione.esercitazionespringboot.model.Exam;

import java.util.Set;

public interface ExamInterface {
    public Exam save(Exam exam);

    public Set<Exam> findAllExams();

    public Exam findExamByID(long id);

    public void deleteRoleByID(long id);

    public Set<Exam> findExamByEvalutation(int vore);
}
