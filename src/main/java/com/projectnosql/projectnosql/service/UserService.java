package com.projectnosql.projectnosql.service;


import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.repository.UserRepository;
import com.projectnosql.projectnosql.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
           return user.get();
        }else{
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

    }
}
