package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.model.Role;
import com.esercitazione.esercitazionespringboot.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/roles")
    public ResponseEntity<ArrayList<Role>> getRuoli() {
        ArrayList<Role> _roles = (ArrayList<Role>) roleRepo.findAll();
        return new ResponseEntity<>(_roles, HttpStatus.OK);
    }

    @PostMapping("/createrole")
    public ResponseEntity<Role> createRuolo(@RequestBody Role role) {
        Role _role = roleRepo.save(role);
        return new ResponseEntity<Role>(_role, HttpStatus.OK);
    }
    @DeleteMapping("/role/{id}")
    public  ResponseEntity<HttpStatus> deleterole(@PathVariable Integer id){
        roleRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}