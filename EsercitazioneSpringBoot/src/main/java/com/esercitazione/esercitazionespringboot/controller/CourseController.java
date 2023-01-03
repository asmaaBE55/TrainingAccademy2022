package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseRepo courseRepo;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courseList=new ArrayList<Course>();
        courseRepo.findAll().forEach(courseList::add);
        if(courseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }
    @PostMapping("/createcourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course _course = courseRepo.save(course);
        return new ResponseEntity<>(_course, HttpStatus.CREATED);
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        courseRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
