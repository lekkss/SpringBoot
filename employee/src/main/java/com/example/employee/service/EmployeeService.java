package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.response.ResponseHandler;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // create
    public Employee creatEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // READ
    public ResponseEntity<Object> getEmployee() {
        try {
            List<Employee> result = employeeRepository.findAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    // update
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());
        return employeeRepository.save(emp);
    }

    // delete
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
