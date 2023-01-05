package com.esercitazione.esercitazionespringboot.repository;

import com.esercitazione.esercitazionespringboot.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByValuationBetween(double minValuation, double maxValuation);
}
