package com.esercitazione.esercitazionespringboot.business.services;

import com.esercitazione.esercitazionespringboot.model.User;

import java.util.Set;

public interface UserInterface {
    public Set<User> findAllUsers();

    public User findUserById(long id);

    public User save(User user);

    public void deleteByID(long id);

    public Boolean existUserByUsername(String username);

    public Boolean existsUserByEmail(String email);
}
