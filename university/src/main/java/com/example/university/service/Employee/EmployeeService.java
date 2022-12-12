package com.example.university.service.Employee;


import com.example.university.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> findAllByRESTApi();

    List<Employee> findSpecificAgeApi(int age);
}
