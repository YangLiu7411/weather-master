package com.example.university.service.student;


import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import com.example.university.repository.StudentAndTeacherRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentAndTeacherRepository studentAndTeacherRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentAndTeacherRepository studentAndTeacherRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.studentAndTeacherRepository = studentAndTeacherRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Optional<Student> findById(String id) {
        Optional<Student> stu = studentRepository.findById(id);
        return stu;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = studentRepository.findAll();

        return list;
    }

    @Override
    public String insert(Student stu) {
//        return studentRepository.insert(stu);
        return studentRepository.save(stu).getId();
    }

    @Override
    public void delete(Student stu) {
        studentRepository.delete(stu);
    }

    @Override
    public String update(Student stu) {
        return studentRepository.saveAndFlush(stu).getId();
    }

    @Override
    public List<StudentAndTeacher> findAllRelations(String id) {
        return studentRepository.findById(findById(id).get().getId()).get().getRelations();
    }

    @Override
    public Teacher findTheRelation(String id, String t) {
        List<StudentAndTeacher> rels = studentRepository.findById(id).get().getRelations();
        for (StudentAndTeacher st : rels) {
            Teacher temp = st.getTea();
            if (temp.getId() == t) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public String addRelations(String id, String t) {
        return studentAndTeacherRepository.save(
                new StudentAndTeacher(
                        studentRepository.findById(id).get(),
                        teacherRepository.findById(t).get())).getId();
    }

    @Override
    public void deleteRelation(String id) {
        studentAndTeacherRepository.delete(studentAndTeacherRepository.findById(id).get());
    }

}
