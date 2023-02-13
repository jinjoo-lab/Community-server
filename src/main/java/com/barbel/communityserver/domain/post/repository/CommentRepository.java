package com.barbel.communityserver.domain.post.repository;

import com.barbel.communityserver.domain.post.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {

}
