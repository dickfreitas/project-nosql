package com.projectnosql.projectnosql.resource;

import com.projectnosql.projectnosql.domain.Comment;
import com.projectnosql.projectnosql.dto.CommentDTO;
import com.projectnosql.projectnosql.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/comment")
public class CommentResource {
    @Autowired
    private CommentService service;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
        try {
            Comment comment = service.createComment(commentDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentDTO.getAuthorId()).toUri();
            return ResponseEntity.created(uri).body(comment);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
