package com.projectnosql.projectnosql.service;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.dto.AuthorDTO;
import com.projectnosql.projectnosql.dto.CommentDTO;
import com.projectnosql.projectnosql.dto.PostDTO;
import com.projectnosql.projectnosql.repository.PostRepository;
import com.projectnosql.projectnosql.repository.UserRepository;
import com.projectnosql.projectnosql.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    @Autowired
    private UserRepository userRepository;
    public Post findPosts(String  id){
        Post post = repository.findById(id).orElse(null);
        if (post != null){
            return  post;
        }else{
            throw new ObjectNotFoundException("Post não encontrado");
        }
    }

    public Post createPost(PostDTO postDTO) {
        try {
            if (postDTO.getAuthorId() == null) {
                throw new IllegalArgumentException("ID do autor não pode ser nulo");
            }
            // Buscar o usuário pelo ID fornecido
            User author = userRepository.findById(postDTO.getAuthorId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

            // Criar o post e definir o autor
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setBody(postDTO.getBody());
            post.setDate(postDTO.getDate());
            AuthorDTO authorDTO = new AuthorDTO(author);
            post.setAuthor(authorDTO); // Definir o usuário como autor do post

            repository.save(post);
            author.getPosts().addAll(Arrays.asList(post));
            userRepository.save(author);
            return repository.save(post);
        } catch (Exception e) {
            // Registre a exceção no log
            e.printStackTrace();
            // Lançar uma exceção mais específica para ser tratada adequadamente
            throw new RuntimeException("Erro ao criar o post: " + e.getMessage());
        }
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
