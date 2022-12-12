package com.example.university.controller;


import com.example.university.entity.Employee;
import com.example.university.service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllByRESTApi());
    }

    @GetMapping("/age>{age}")
    public ResponseEntity<List<Employee>> findAllEmpGreaterThanAge(@PathVariable int age) {
        return ResponseEntity.ok(employeeService.findSpecificAgeApi(age));
    }
}
