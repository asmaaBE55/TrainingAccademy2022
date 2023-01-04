package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.Role;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.repository.CourseRepo;
import com.esercitazione.esercitazionespringboot.repository.RoleRepo;
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

    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers (){
        List<User> uArrayList = new ArrayList<User>();
        userRepo.findAll().forEach(uArrayList::add);
        if (uArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(uArrayList, HttpStatus.OK);
    }
    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User u) {
        User insertedU = userRepo.save(u);
        return new ResponseEntity<>(insertedU, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    @GetMapping("/getcourses/{user_id}")
    public ResponseEntity<Set<Course>> getCourses (@PathVariable(value = "user_id") Long userId){
        Set<Course> courseArrayList;
        User choosenUser = userRepo.findById(userId).orElse(null);
        if (choosenUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        courseArrayList = choosenUser.getCourses();
        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }
    @GetMapping("/getroles/{user_id}")
    public ResponseEntity<Set<Role>> getRoles(@PathVariable(value = "user_id") Long userId){
        Set<Role> roleList;
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        roleList=roleRepo.getRoles();
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }
    @PostMapping("/insertroletouser/{user_id}")
    public ResponseEntity<User> addRoleToUser(@PathVariable(value = "userI_id") Long userId, @RequestBody Role role) {
        Role _role = roleRepo.findById(role.getId()).orElse(null);
        User choosenUser = userRepo.findById(userId).orElse(null);
        if( _role != null && choosenUser != null){
            choosenUser.addRole(_role);
            User newUser =  userRepo.save(choosenUser);
            return new ResponseEntity<>(newUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
