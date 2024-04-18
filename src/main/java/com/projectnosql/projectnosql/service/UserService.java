package com.projectnosql.projectnosql.service;

import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
