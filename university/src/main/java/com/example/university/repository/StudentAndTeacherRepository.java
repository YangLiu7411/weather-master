package com.example.university.repository;

import com.example.university.entity.StudentAndTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAndTeacherRepository extends JpaRepository<StudentAndTeacher, String> {
}
