package com.projectnosql.projectnosql.service;


import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.dto.UserDTO;
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
        User user = repository.findById(id).orElse(null);
        if (user!=null) {
           return user;
        }else{
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

    }

    public User insert(User obj){
        return  repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User newUser = repository.findById(obj.getId()).orElse(null);
        updateData(newUser , obj);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User obj) {
        newUser.setEmail(obj.getEmail());
        newUser.setName(obj.getName());
    }

    public User fromDto(UserDTO dto){
        return new User(dto.getId() , dto.getName() , dto.getEmail());
    }
}
