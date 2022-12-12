package com.example.university.entity.trans;

import com.example.university.entity.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


public class EmpTransfer {
    @JsonProperty("status")
    String status;
    @JsonProperty("data")
    List<Employee> data;

    @JsonProperty("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
