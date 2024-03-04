package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.creatEmployee(emp);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        return employeeService.getEmployee();
    }

    @PutMapping("/employees/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Long id, @RequestBody Employee empDetails) {
        return employeeService.updateEmployee(id, empDetails);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
