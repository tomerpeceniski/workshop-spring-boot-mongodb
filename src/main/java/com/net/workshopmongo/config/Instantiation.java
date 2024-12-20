package com.net.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.net.workshopmongo.domain.Post;
import com.net.workshopmongo.domain.User;
import com.net.workshopmongo.repository.PostRepository;
import com.net.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("2018-03-21"), "Let's travel!", "I will trasvel to London!", maria);
        Post post2 = new Post(null, LocalDate.parse("2018-03-23"), "Good Morning!", "I woke up happy today!", maria);
    
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
