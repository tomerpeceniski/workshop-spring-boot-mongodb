package com.net.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.net.workshopmongo.domain.Post;
import com.net.workshopmongo.domain.User;
import com.net.workshopmongo.dto.AuthorDTO;
import com.net.workshopmongo.dto.CommentDTO;
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

        Post post1 = new Post(null, LocalDate.parse("2018-03-21"), "Let's travel!", "I will travel to London!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("2018-03-23"), "Good Morning!", "I woke up happy today!", new AuthorDTO(maria));
    
        CommentDTO c1 = new CommentDTO("Good Luck there!", LocalDate.parse("2018-03-21"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy!", LocalDate.parse("2018-03-22"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Have a nice day!", LocalDate.parse("2018-03-23"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
