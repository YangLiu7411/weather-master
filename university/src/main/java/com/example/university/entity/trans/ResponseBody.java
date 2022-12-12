package com.example.university.entity.trans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> {
    private HttpStatus httpStatus;
    private Date date;
    private ResponseEntity<T> responseEntity;
}
