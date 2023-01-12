package com.esercitazione.esercitazionespringboot.business.impl;

import com.esercitazione.esercitazionespringboot.business.services.CourseInterface;
import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseImpl implements CourseInterface {
    @Autowired
    CourseRepo courseRepo;

    @Override
    public Course save(Course course) {
        courseRepo.save(course);
        return course;
    }

    @Override
    public void deleteByID(long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course findCourseByID(long id) {
        Course _course = courseRepo.getReferenceById(id);
        return _course;
    }

    @Override
    public List<Course> findAllCourse() {
        return (List<Course>) courseRepo.findAll();
    }
}
