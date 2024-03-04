package com.example.modelmapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelmapper.DTO.UserDto;
import com.example.modelmapper.model.User;
import com.example.modelmapper.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreaed = userServiceImpl.createUser(user);
        return new ResponseEntity<User>(userCreaed, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id) {
        UserDto userDto = userServiceImpl.getUser(id);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
