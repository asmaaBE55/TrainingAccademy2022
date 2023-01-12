package com.esercitazione.esercitazionespringboot.business.impl;

import com.esercitazione.esercitazionespringboot.business.services.RoleInterface;
import com.esercitazione.esercitazionespringboot.model.Role;
import com.esercitazione.esercitazionespringboot.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleImpl implements RoleInterface {

    @Autowired
    RoleRepo roleRepo;

    @Override
    public Role findRoleByID(long id) {
        return roleRepo.getReferenceById((int) id);
    }

    @Override
    public Role save(Role role) {
        roleRepo.save(role);
        return role;
    }

    @Override
    public Set<Role> findAllRole() {
        return (Set<Role>) roleRepo.findAll();
    }

    @Override
    public void deleteRoleByID(long id) {
        roleRepo.deleteById((int) id);
    }
}