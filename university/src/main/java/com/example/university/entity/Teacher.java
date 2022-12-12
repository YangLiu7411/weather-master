package com.example.university.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tea", cascade = CascadeType.ALL)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentAndTeacher> getRelations() {
        return relations;
    }

    public void setRelations(List<StudentAndTeacher> relations) {
        this.relations = relations;
    }
}
