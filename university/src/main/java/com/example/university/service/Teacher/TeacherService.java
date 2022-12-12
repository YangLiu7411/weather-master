package com.example.university.service.Teacher;


import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeacherService {
    String insert(Teacher teacher);
    String update(Teacher teacher);
    Optional<Teacher> findById(String id);
    List<Teacher> findAll();
    void delete(Teacher teacher);
    List<StudentAndTeacher> findAllRelations(String id);
    Student findTheRelation(String id, String t);
    String addRelations(String id, String t);
    void deleteRelation(String id);
}
