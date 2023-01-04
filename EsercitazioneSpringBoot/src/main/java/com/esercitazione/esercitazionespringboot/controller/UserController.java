package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import com.esercitazione.esercitazionespringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
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
