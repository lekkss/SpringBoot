package com.example.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactionmanagement.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
