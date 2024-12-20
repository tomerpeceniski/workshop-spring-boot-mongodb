package com.net.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.workshopmongo.domain.Post;
import com.net.workshopmongo.repository.PostRepository;
import com.net.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
