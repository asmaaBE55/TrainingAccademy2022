package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import com.esercitazione.esercitazionespringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courseList=new ArrayList<Course>();
        courseRepo.findAll().forEach(courseList::add);
        if(courseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseRepo.getCourseById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course _course = courseRepo.save(course);
        return new ResponseEntity<>(_course, HttpStatus.CREATED);
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        courseRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> modifyCourse(@PathVariable("id") long id, @RequestBody Course course) {
        Course existingCourse = courseRepo.getCourseById(id);
        if (existingCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCourse.setName_course(course.getName_course());
        existingCourse.setDescription(course.getDescription());
        Course updateCourse = courseRepo.save(existingCourse);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);
    }

    @PostMapping("/user/{id}/course")
    public ResponseEntity<Course> CreateCourseUser(@PathVariable Long id ,@RequestBody Course course) {
        User user = userRepo.getReferenceById(id);
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        course.setUsers(userSet);
        Course _course = courseRepo.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
