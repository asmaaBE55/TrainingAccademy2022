package com.esercitazione.esercitazionespringboot.business.services;

import com.esercitazione.esercitazionespringboot.model.Role;

import java.util.Set;

public interface RoleInterface {
    public Role findRoleByID(long id);

    public Role save(Role role);

    public Set<Role> findAllRole();

    public void deleteRoleByID(long id);
}
