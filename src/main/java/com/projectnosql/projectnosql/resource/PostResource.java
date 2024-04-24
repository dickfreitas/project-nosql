package com.projectnosql.projectnosql.resource;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.dto.CommentDTO;
import com.projectnosql.projectnosql.dto.PostDTO;
import com.projectnosql.projectnosql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/post")
public class PostResource {
    @Autowired
    private PostService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findPosts(@PathVariable String id){
        Post post = service.findPosts(id);

        return ResponseEntity.ok().body(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post created = service.createPost(postDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDTO.getTitle()).toUri();
        return ResponseEntity.created(uri).body(created);
    }


}
