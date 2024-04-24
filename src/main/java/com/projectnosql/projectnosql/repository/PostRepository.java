package com.projectnosql.projectnosql.repository;

import com.projectnosql.projectnosql.domain.Post;
import com.projectnosql.projectnosql.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
