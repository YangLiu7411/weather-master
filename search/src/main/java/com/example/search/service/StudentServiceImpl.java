package com.example.search.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final RestTemplate ribbonRestTemplate;

    public StudentServiceImpl(RestTemplate ribbonRestTemplate) {
        this.ribbonRestTemplate = ribbonRestTemplate;
    }

    @Override
    public List<?> findAllStudents() {
        return ribbonRestTemplate.getForObject("http://university/student", List.class);
    }
}
