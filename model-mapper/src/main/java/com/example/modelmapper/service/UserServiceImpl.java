package com.example.modelmapper.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelmapper.DTO.UserDto;
import com.example.modelmapper.model.User;
import com.example.modelmapper.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User userSavedToDB = userRepository.save(user);
        return userSavedToDB;
    }

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.findById(userId).get();
        // map the user to the dto class
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
