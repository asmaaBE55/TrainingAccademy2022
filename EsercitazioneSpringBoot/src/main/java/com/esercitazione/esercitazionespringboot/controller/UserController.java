package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.business.services.CourseInterface;
import com.esercitazione.esercitazionespringboot.business.services.RegisterInterface;
import com.esercitazione.esercitazionespringboot.business.services.RoleInterface;
import com.esercitazione.esercitazionespringboot.business.services.UserInterface;
import com.esercitazione.esercitazionespringboot.model.Course;
import com.esercitazione.esercitazionespringboot.model.Role;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.payload.request.SignupRequest;
import com.esercitazione.esercitazionespringboot.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RegisterInterface registerInterface;
    @Autowired
    UserInterface userInterface;
    @Autowired
    CourseInterface courseInterface;
    @Autowired
    RoleInterface roleInterface;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User _user = userInterface.save(user);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }
    @PostMapping("/user/add")
    public ResponseEntity<?> createUserAdmin(@RequestBody SignupRequest signUpRequest) {
        String msg = registerInterface.createUserBusiness(signUpRequest);

        switch (msg) {
            case "usernameExists":
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
            case "emailExists":
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @GetMapping("/users")
    public ResponseEntity<Set<User>> getUsers() {
        Set<User> setUsers = new LinkedHashSet<>();
        setUsers = userInterface.findAllUsers();

        if (setUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(setUsers, HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User userRequest) {
        User _user = userInterface.findUserById(id);

        if (_user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _user.setUsername(userRequest.getUsername());
            _user.setEmail(userRequest.getEmail());
            _user.setPassword(userRequest.getPassword());
            _user.setCourses(userRequest.getCourses());

            User result = userInterface.save(_user);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        userInterface.deleteByID(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("insertCourse/{idUser}/existcours")
    public ResponseEntity<Course> insertCourse(@PathVariable("idUser") long idUser, @RequestBody Course courseRequest) {

        User _user = userInterface.findUserById(idUser);
        Course _course = courseInterface.findCourseByID(courseRequest.getId());

        Set<User> userSet = new HashSet<>();
        userSet.add(_user);
        _course.setUsers(userSet);
        Course user_course = courseInterface.save(_course);

        return new ResponseEntity<>(user_course, HttpStatus.NOT_FOUND);

    }
    @PostMapping("insertCourse/{idUser}/course")
    public ResponseEntity<User> createCourseUser(@PathVariable("idUser") long idUser, @RequestBody Course courseRequest) {
        User _user = userInterface.findUserById(idUser);
        Set<User> userSet = new HashSet<>();
        userSet.add(_user);
        courseRequest.setUsers(userSet);
        courseInterface.save(courseRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("insertCourse/{id}/courses")
    public Set<Course> getCoursesUser(@PathVariable("id") long id) {
        User _user = userInterface.findUserById(id);

        return _user.getCourses();
    }
    @PostMapping("role/assign/{id}")
    public ResponseEntity<User> assignRole(@PathVariable("id") long id, @RequestBody Role roleRequest) {

        User _user = userInterface.findUserById(id);
        Role _role = roleInterface.findRoleByID(roleRequest.getId());

        if (_user == null || _role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Set<Role> roleUser = new HashSet<>();

            roleUser.add(_role);
            _user.setRoles(roleUser);
            User newUser = userInterface.save(_user);

            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
    }
    @GetMapping("role/user/{id}")
    public Set<Role> getRoleUser(@PathVariable("id") long id) {

        User _user = userInterface.findUserById(id);

        return _user.getRoles();
    }
    @GetMapping("role/{id}")
    public Set<User> getUserRole(@PathVariable("id") long id) {

        //Role _role = roleRepository.getReferenceById(id);
        Role _role = roleInterface.findRoleByID(id);

        return _role.getUsers();
    }
}
