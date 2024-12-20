package com.net.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.net.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    // Simple Query MongoDB Method:
    // List<Post> findByTitleContainingIgnoreCase(String text);

    // Personalized Query:
    @Query(" { 'title': {$regex: ?0, $options: 'i' } } ")
    List<Post> searchTitle(String title);
}
