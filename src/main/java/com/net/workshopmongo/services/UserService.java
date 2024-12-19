package com.net.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.workshopmongo.domain.User;
import com.net.workshopmongo.repository.UserRepository;
import com.net.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
