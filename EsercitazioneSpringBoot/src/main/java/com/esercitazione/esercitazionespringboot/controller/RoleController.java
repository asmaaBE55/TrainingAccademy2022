package com.esercitazione.esercitazionespringboot.controller;

import com.esercitazione.esercitazionespringboot.business.services.RoleInterface;
import com.esercitazione.esercitazionespringboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleInterface roleInterface;

    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role roleRequest) {
        Role _role = roleInterface.save(roleRequest);
        return new ResponseEntity<>(_role, HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getRole() {
        Set<Role> roles = new HashSet<>();
        //roleRepository.findAll().forEach(roles::add);
        roles = roleInterface.findAllRole();

        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role roleRequest) {
        //Role _role = roleRepository.findById(id).orElse(null);
        Role _role = roleInterface.findRoleByID(id);

        if (_role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _role.setName(roleRequest.getName());

            Role result = roleInterface.save(_role);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @DeleteMapping("role/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") long id) {
        roleInterface.deleteRoleByID(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}