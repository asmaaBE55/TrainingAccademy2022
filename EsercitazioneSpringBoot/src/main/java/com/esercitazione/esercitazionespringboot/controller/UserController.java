package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.Role;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.payload.request.SignupRequest;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import com.esercitazione.esercitazionespringboot.repository.RoleRepo;
import com.esercitazione.esercitazionespringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.esercitazione.esercitazionespringboot.model.ERole.ROLE_ADMIN;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;



    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User _user = userRepo.getReferenceById(id);
        return new ResponseEntity<User>(_user,HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User _user = userRepo.save(user);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }
    @PostMapping("/user/createadmin")
    public ResponseEntity<User> createUserAdmin(@RequestBody SignupRequest signUpRequest) {
        User user = new User();
        Role role = new Role();
        role.setName(ROLE_ADMIN);
        user.getRoles().add(role);
        User _user = userRepo.save(user);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }


    //endpoint moderator e admin
}
