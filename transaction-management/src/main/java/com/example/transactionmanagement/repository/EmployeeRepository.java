package com.example.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactionmanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
