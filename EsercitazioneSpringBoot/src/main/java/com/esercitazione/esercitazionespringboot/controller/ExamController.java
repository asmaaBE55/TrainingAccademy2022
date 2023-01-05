package com.esercitazione.esercitazionespringboot.controller;


import com.esercitazione.esercitazionespringboot.model.Exam;
import com.esercitazione.esercitazionespringboot.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @PostMapping("/createexam")
    public Exam addExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @GetMapping("/getexams")
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @GetMapping("/getexam/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examRepository.findById(id).orElse(null);
    }

    @PutMapping("/modifyexam/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        Exam existingExam = examRepository.findById(id).orElse(null);
        if (existingExam != null) {
            existingExam.setValuation(exam.getValuation());
            existingExam.setCourse(exam.getCourse());
            return examRepository.save(existingExam);
        }
        return null;
    }

    @DeleteMapping("/deleteexam/{id}")
    public void deleteExam(@PathVariable Long id) {
        examRepository.deleteById(id);
    }

    @GetMapping("/search/valuation")
    public List<Exam> getExamsByValuationRange
            (@RequestParam double minValuation, @RequestParam double maxValuation) {
        return examRepository.findByValuationBetween(minValuation, maxValuation);
    }
}

