package com.example.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionmanagement.model.Address;
import com.example.transactionmanagement.model.Employee;
import com.example.transactionmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

    @Transactional
    public Employee addEmployee(Employee employee) throws Exception {
        Employee employeeSavedToDB = this.employeeRepository.save(employee);

        // Address address = new Address();
        Address address = null;
        address.setId(123L);
        address.setAddress("Ireland");
        address.setEmployee(employee);

        this.addressService.addAddress(address);
        return employeeSavedToDB;
    }
}
