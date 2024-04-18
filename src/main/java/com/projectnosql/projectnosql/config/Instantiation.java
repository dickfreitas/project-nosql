package com.projectnosql.projectnosql.config;

import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User u1 = new User(null , "Maria Green" , "maria@gmail.com");
        User u2 = new User(null , "Pedro Brown" , "pedro@gmail.com");
        User u3 = new User(null , "Bob grey" , "bob@gmail.com");

        repository.saveAll(Arrays.asList(u1,u2,u3));

    }
}
