package com.example.university.service.Employee;

import com.example.university.entity.trans.EmpTransfer;
import com.example.university.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Value("${targetURL}")
    private String url;

    private  RestTemplate template = new RestTemplate();



    @Override
    public List<Employee> findAllByRESTApi() {
        EmpTransfer data = template.getForObject(url, EmpTransfer.class);
        return data.getData();
    }

    @Override
    public List<Employee> findSpecificAgeApi(int age) {
        List<Employee> data = template.getForObject(url, EmpTransfer.class).getData().stream()
                .filter(e -> e.getEmployee_age()>age).collect(Collectors.toList());
        return data;
    }
}
