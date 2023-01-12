package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.business.services.CourseInterface;
import com.esercitazione.esercitazionespringboot.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseInterface courseInterface;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourses(@RequestBody Course course) {
        Course _course = courseInterface.save(course);
        return new ResponseEntity<>(_course, HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courseArrayList;
        courseArrayList = courseInterface.findAllCourse();
        if (courseArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }

    @DeleteMapping("course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {

        courseInterface.deleteByID(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course courseRequest) {

        Course _course = courseInterface.findCourseByID(id);

        if (_course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _course.setDescription(courseRequest.getDescription());
            _course.setName_course(courseRequest.getName_course());

            Course result = courseInterface.save(_course);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {
        Course _course = courseInterface.findCourseByID(id);
        if (_course == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(_course, HttpStatus.OK);
        }
    }
}
