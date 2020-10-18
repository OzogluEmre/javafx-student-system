package com.example.JavaFX.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="exam")
public class Exam {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "exam_code")
    private String examCode;

    @Column(name = "exam_class")
    private String examClass;

    @Column(name = "exam_date")
    private String examDate;

    @Column(name = "exam_location")
    private String examLocation;

    @Column(name = "exam_duration")
    private String examDuration;

    @OneToMany(mappedBy = "exam", fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<StudentExams> studentExams = new HashSet();

}
