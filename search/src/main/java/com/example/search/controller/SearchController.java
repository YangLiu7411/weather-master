package com.example.search.controller;

import com.example.search.service.EmployeeService;
import com.example.search.service.StudentService;
import com.sun.org.slf4j.internal.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    private final EmployeeService employeeService;
    private final StudentService studentService;


    public SearchController(EmployeeService employeeService, StudentService studentService) {
        this.employeeService = employeeService;
        this.studentService = studentService;
    }

    @GetMapping("/all_employees")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStus() {
        //TODO
        Logger logger = new Logger("Logger test");
        logger.error("test error log");
        logger.debug("test debug log");
        logger.warn("test warn log");
        return new ResponseEntity(studentService.findAllStudents(), HttpStatus.OK);
    }
}
