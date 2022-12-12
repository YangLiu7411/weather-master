package com.example.university.service.Teacher;


import com.example.university.entity.Student;
import com.example.university.entity.StudentAndTeacher;
import com.example.university.entity.Teacher;
import com.example.university.repository.StudentAndTeacherRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final StudentAndTeacherRepository studentAndTeacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentRepository studentRepository, StudentAndTeacherRepository studentAndTeacherRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.studentAndTeacherRepository = studentAndTeacherRepository;
    }

    @Override
    public String insert(Teacher teacher) {
        return teacherRepository.save(teacher).getId();
    }

    @Override
    public String update(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher).getId();
    }

    @Override
    public Optional<Teacher> findById(String id) {

        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {

        return teacherRepository.findAll();
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public List<StudentAndTeacher> findAllRelations(String id) {
        return teacherRepository.findById(id).get().getRelations();
    }

    @Override
    public Student findTheRelation(String id, String t) {
        List<StudentAndTeacher> rels = teacherRepository.findById(id).get().getRelations();
        for (StudentAndTeacher st : rels) {
            Student temp = st.getStu();
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
