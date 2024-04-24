package com.projectnosql.projectnosql.service;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.repository.PostRepository;
import com.projectnosql.projectnosql.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findPosts(String  id){
        Post post = repository.findById(id).orElse(null);
        if (post != null){
            return  post;
        }else{
            throw new ObjectNotFoundException("Post não encontrado");
        }
    }
}
