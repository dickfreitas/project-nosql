package com.projectnosql.projectnosql.service;

import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
