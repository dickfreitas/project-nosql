package com.projectnosql.projectnosql.service;

import com.projectnosql.projectnosql.domain.Comment;
import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import com.projectnosql.projectnosql.dto.AuthorDTO;
import com.projectnosql.projectnosql.dto.CommentDTO;
import com.projectnosql.projectnosql.repository.CommentRepository;
import com.projectnosql.projectnosql.repository.PostRepository;
import com.projectnosql.projectnosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment createComment(CommentDTO commentDTO){
        try {
            if(commentDTO.getPostId() == null){
                throw new IllegalArgumentException("Id do post não encontrado");
            }
            User author = userRepository.findById(commentDTO.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
            Post post = postRepository.findById(commentDTO.getPostId()).orElse(null);
            Comment comment = new Comment();
            comment.setText(commentDTO.getText());
            comment.setDate(commentDTO.getDate());
            AuthorDTO authorDTO = new AuthorDTO(author);
            comment.setAuthor(authorDTO);

            // Adiciona o comentário ao post
            post.getComments().add(comment);

            // Salva o comentário e o post
            commentRepository.save(comment);
            postRepository.save(post);

            return comment;


        }catch (Exception e ){
            throw new RuntimeException("Erro ao adicionar comentario: " + e.getMessage());
        }
    }
}
