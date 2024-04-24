package com.projectnosql.projectnosql.config;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.dto.AuthorDTO;
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

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null ,sdf.parse("21/03/2024"), "Vou viajar amanha" , "Irei viajar para fernando de noronha" , new AuthorDTO(u1) );
        Post p2 = new Post(null ,sdf.parse("21/03/2024"), "Pedalada matinal" , "200km frio frio" , new AuthorDTO(u1) );
        Post p3 = new Post(null ,sdf.parse("22/03/2024"), "Virar triatleta" , "A loucura total" , new AuthorDTO(u2) );


        postRepository.saveAll(Arrays.asList(p1,p2,p3));

        u1.getPosts().addAll(Arrays.asList(p1,p2));
        u2.getPosts().addAll(Arrays.asList(p3));

        userRepository.save(u1);
        userRepository.save(u2);



    }
}
