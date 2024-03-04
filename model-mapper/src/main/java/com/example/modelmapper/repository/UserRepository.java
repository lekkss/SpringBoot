package com.example.modelmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelmapper.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
