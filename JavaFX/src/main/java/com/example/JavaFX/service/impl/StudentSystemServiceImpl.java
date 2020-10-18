package com.example.JavaFX.service.impl;

import com.example.JavaFX.model.StudentExams;
import com.example.JavaFX.repository.StudentExamsRepository;
import com.example.JavaFX.service.StudentSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSystemServiceImpl implements StudentSystemService {


    @Autowired
    StudentExamsRepository studentExamsRepository;

}
