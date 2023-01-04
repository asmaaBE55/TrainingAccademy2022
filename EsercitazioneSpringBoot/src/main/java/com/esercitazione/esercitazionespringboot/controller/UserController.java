package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import com.esercitazione.esercitazionespringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    UserRepo userRepo;


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User _user = userRepo.getReferenceById(id);
        return new ResponseEntity<User>(_user,HttpStatus.OK);
    }


    @PostMapping("/users/{user_id}/course")
    public ResponseEntity<Void> addCourseToUser(@PathVariable Long user_id,@RequestBody Course course) {
        User user = userRepo.getReferenceById(user_id);
        Set<User> userSet=new HashSet<>();
        userSet.add(user);
        course.setUsers(userSet);
        courseRepo.save(course);
        return ResponseEntity.ok().build();
    }
}
