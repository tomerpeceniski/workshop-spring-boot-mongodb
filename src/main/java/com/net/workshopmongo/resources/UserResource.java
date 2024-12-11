package com.net.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.workshopmongo.domain.User;
import com.net.workshopmongo.dto.UserDTO;
import com.net.workshopmongo.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(u -> new UserDTO(u)).toList();
        return ResponseEntity.ok().body(listDto);
    }
}
