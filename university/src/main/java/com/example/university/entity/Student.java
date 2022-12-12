package com.example.university.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")

public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stu", cascade = CascadeType.ALL)
    private List<StudentAndTeacher> relations = new ArrayList<>();

    public boolean addRelations(StudentAndTeacher rel) {
        relations.add(rel);
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<StudentAndTeacher> getRelations() {
        return relations;
    }

    public void setRelations(List<StudentAndTeacher> relations) {
        this.relations = relations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(relations, student.relations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, relations);
    }
}
