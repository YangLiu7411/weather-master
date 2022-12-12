package com.example.university.controller;

import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import com.example.university.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findStuById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.insert(student));
    }

    @PutMapping(value = "/{id}") //, consumes = {"multipart/mixed"}
    public ResponseEntity<String> update(@PathVariable String id, @RequestParam("name") String name){
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        return ResponseEntity.ok(studentService.update(stu));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //应该返回一个boolean?
        Optional<Student> stu = studentService.findById(id);
        studentService.delete(stu.get());
    }
//
    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<StudentAndTeacher>> findAllRelations(@PathVariable String id) {
        return ResponseEntity.ok(studentService.findAllRelations(id));
    }

    @GetMapping("/{id}/teachers/{t_id}")
    public ResponseEntity<Teacher> findTheRelation(@PathVariable String id, @PathVariable String t_id) {
        return ResponseEntity.ok(studentService.findTheRelation(id, t_id));
    }


    @PutMapping("/{id}/teachers")
    public ResponseEntity<String> putRelationByStuAndTea(@PathVariable String id,
                                                         @RequestParam("t_id") String t) {
        return ResponseEntity.ok(studentService.addRelations(id, t));
    }

    @DeleteMapping("/{id}/remove_tea/{r_id}")
    public void delete(@PathVariable String id, @PathVariable String r_id) {

        studentService.deleteRelation(r_id);
    }

}
