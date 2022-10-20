package com.learn.joblisting.repository;

import com.learn.joblisting.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
    // read and fetch the data form the mongodb repository and provide it to swagger...

}
