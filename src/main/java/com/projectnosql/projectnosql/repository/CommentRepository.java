package com.projectnosql.projectnosql.repository;

import com.projectnosql.projectnosql.domain.Comment;
import com.projectnosql.projectnosql.dto.CommentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
