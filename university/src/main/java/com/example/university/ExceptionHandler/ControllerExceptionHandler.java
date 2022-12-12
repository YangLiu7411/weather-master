package com.example.university.ExceptionHandler;
import com.example.university.entity.trans.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseBody> resourceNotFoundException(RuntimeException ex, WebRequest request) {
//        ResponseBody message = new ResponseBody(HttpStatus.NOT_FOUND,new Date(),new ResponseEntity(null));
        return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody> globalExceptionHandler(Exception ex, WebRequest request) {
//        ResponseBody message = new ResponseBody(
//                HttpStatus.INTERNAL_SERVER_ERROR, new Date(),
//                new ResponseEntity(null));

        return new ResponseEntity("internal", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}