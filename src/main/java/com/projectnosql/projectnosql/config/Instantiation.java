package com.projectnosql.projectnosql.config;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.dto.AuthorDTO;
import com.projectnosql.projectnosql.dto.CommentDTO;
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

        User u1 = new User(null , "Maria Green" , "maria@gmail.com");
        User u2 = new User(null , "Pedro Brown" , "pedro@gmail.com");
        User u3 = new User(null , "Bob grey" , "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null ,sdf.parse("21/03/2024"), "Vou viajar amanha" , "Irei viajar para fernando de noronha" , new AuthorDTO(u1) );
        Post p2 = new Post(null ,sdf.parse("21/03/2024"), "Pedalada matinal1233" , "200km frio frio" , new AuthorDTO(u1) );
        Post p3 = new Post(null ,sdf.parse("22/03/2024"), "Virar triatleta" , "A loucura total" , new AuthorDTO(u2) );
        Post p4 = new Post(null ,sdf.parse("22/03/2024"), "Ir a fernando de noronha" , "A loucura total" , new AuthorDTO(u3) );

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(u1));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(u1));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(u2));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        u1.getPosts().addAll(Arrays.asList(p1,p2));
        u2.getPosts().addAll(Arrays.asList(p3));
        u3.getPosts().addAll(Arrays.asList(p4));

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);




    }
}
