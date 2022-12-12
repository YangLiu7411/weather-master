package com.example.employee.controller;

import com.example.employee.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @HystrixCommand(fallbackMethod = "wrongBack", commandKey = "wrongBack")
    public ResponseEntity<?> getAllEmp(@RequestParam int age) {
        return new ResponseEntity<>(employeeService.fetchEmpAgeLargerThan(age), HttpStatus.OK);
    }

    @GetMapping("/All")
    @HystrixCommand(fallbackMethod = "wrongBack", commandKey = "wrongBack")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> wrongBack() {
        return ResponseEntity.ok("Something wrong, please try it later.");
    }

}
