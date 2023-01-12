package com.esercitazione.esercitazionespringboot.business.services;

import com.esercitazione.esercitazionespringboot.model.Course;

import java.util.List;

public interface CourseInterface {
    public Course save(Course course);

    public void deleteByID(long id);

    public Course findCourseByID(long id);

    public List<Course> findAllCourse();
}
