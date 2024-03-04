package com.example.modelmapper.service;

import com.example.modelmapper.DTO.UserDto;
import com.example.modelmapper.model.User;

public interface UserService {
    public User createUser(User user);

    public UserDto getUser(int id);

}
