package com.example.university.service.student;

import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface StudentService {
    Optional<Student> findById(String id);
    List<Student> findAll();
    String insert(Student stu);
    void delete(Student stu);
    String update(Student stu);
    List<StudentAndTeacher> findAllRelations(String id);
    Teacher findTheRelation(String id, String t);
    String addRelations(String id, String t);
    void deleteRelation(String id);

}
