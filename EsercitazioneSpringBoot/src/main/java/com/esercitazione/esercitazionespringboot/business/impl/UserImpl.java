package com.esercitazione.esercitazionespringboot.business.impl;

import com.esercitazione.esercitazionespringboot.business.services.UserInterface;
import com.esercitazione.esercitazionespringboot.model.User;
import com.esercitazione.esercitazionespringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserImpl implements UserInterface {
    @Autowired
    UserRepo userRepo;

    @Override
    public Set<User> findAllUsers() {

        return (Set<User>) userRepo.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepo.getReferenceById(id);
    }

    @Override
    public User save(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteByID(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Boolean existUserByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
