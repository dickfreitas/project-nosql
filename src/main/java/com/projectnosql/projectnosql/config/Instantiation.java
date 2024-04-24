package com.projectnosql.projectnosql.config;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.repository.PostRepository;
import com.projectnosql.projectnosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null , "Maria Green" , "maria@gmail.com");
        User u2 = new User(null , "Pedro Brown" , "pedro@gmail.com");
        User u3 = new User(null , "Bob grey" , "bob@gmail.com");

        Post p1 = new Post(null ,sdf.parse("21/03/2024"), "Vou viajar amanha" , "Irei viajar para fernando de noronha" , u1 );
        Post p2 = new Post(null ,sdf.parse("21/03/2024"), "Pedalada matinal" , "200km frio frio" , u1 );
        Post p3 = new Post(null ,sdf.parse("22/03/2024"), "Virar triatleta" , "A loucura total" , u2 );

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        postRepository.saveAll(Arrays.asList(p1,p2,p3));


    }
}
