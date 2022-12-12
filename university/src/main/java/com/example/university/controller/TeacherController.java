package com.example.university.controller;

import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import com.example.university.service.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController (TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Teacher>> findById(@PathVariable String id) {
        return ResponseEntity.ok(teacherService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.update(teacher));
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.insert(teacher));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //应该返回一个boolean?
        Optional<Teacher> tea = teacherService.findById(id);
        teacherService.delete(tea.get());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentAndTeacher>> findAllAllRelations(@PathVariable String id) {
        return ResponseEntity.ok(teacherService.findAllRelations(id));
    }

    @GetMapping("/{id}/students/{t_id}")
    public ResponseEntity<Student> findTheRelation(@PathVariable String id, @PathVariable String t_id) {
        return ResponseEntity.ok(teacherService.findTheRelation(id, t_id));
    }


    @PutMapping("/{id}/students")
    public ResponseEntity<String> putRelationByStuAndTea(@PathVariable String id,
                                                         @RequestParam("t_id") String t) {
        return ResponseEntity.ok(teacherService.addRelations(id, t));
    }

    @DeleteMapping("/{id}/remove_stu/{r_id}")
    public void delete(@PathVariable String id, @PathVariable String r_id) {

        teacherService.deleteRelation(r_id);
    }
}

