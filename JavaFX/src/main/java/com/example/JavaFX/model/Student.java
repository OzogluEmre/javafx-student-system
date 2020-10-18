package com.example.JavaFX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student_system")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "adress")
    private String adress;

    @Column(name = "gender")
    private String gender;

    @Column(name = "school_class")
    private String schoolClass;

    @Column(name = "register_date")
    private String registerDate;

    @Column(name = "grade")
    private String grade;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
    private Set<StudentExams> studentExams = new HashSet<>();





}
