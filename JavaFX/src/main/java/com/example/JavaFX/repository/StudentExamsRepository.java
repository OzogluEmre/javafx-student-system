package com.example.JavaFX.repository;


import com.example.JavaFX.model.StudentExams;
import org.hibernate.service.spi.InjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentExamsRepository extends JpaRepository<StudentExams,Long> {


}
