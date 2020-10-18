package com.example.JavaFX.controller;

import com.example.JavaFX.model.Exam;
import com.example.JavaFX.model.Student;
import com.example.JavaFX.model.StudentExams;
import com.example.JavaFX.repository.ExamRepository;
import com.example.JavaFX.repository.StudentExamsRepository;
import com.example.JavaFX.repository.StudentRepository;
import com.example.JavaFX.service.StudentSystemService;
import com.sun.javafx.menu.MenuItemBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

@Component
public class StudentUiController {

   @Autowired
   StudentRepository studentRepository;

   @Autowired
   StudentExamsRepository studentExamsRepository;

   @Autowired
   StudentSystemService studentSystemService;

   @FXML
   private TextField nameField;

   @FXML
   private TextField birthDateField;

   @FXML
   private TextField genderField;

   @FXML
   private TextField schoolClassField;

   @FXML
   private TextField addressField;

   @FXML
   private TextField registerDateField;


   @FXML
   private Button studentInsertButton;


   @FXML
   private javafx.scene.control.TableView<Student> studentTableView;

   @FXML
   private TableColumn<Student, Long> idColumn;

   @FXML
   private TableColumn<Student, String> nameColumn;

   @FXML
   private TableColumn<Student, String> birthDateColumn;

   @FXML
   private TableColumn<Student, String> genderColumn;

   @FXML
   private TableColumn<Student, String> classColumn;

   @FXML
   private TableColumn<Student, String> addressColumn;

   @FXML
   private TableColumn<Student, String> registerDateColumn;
   @FXML
   private TableColumn<Student, String> gradeColumn;

   @Autowired
   ExamRepository examRepository;


   @FXML
   private TextField subjectNameField;

   @FXML
   private TextField examCodeField;

   @FXML
   private TextField examClassField;

   @FXML
   private TextField examDateField;

   @FXML
   private TextField examLocationField;

   @FXML
   private TextField examDurationField;


   @FXML
   private Button examInsertButton;


   @FXML
   private TableView<Exam> examTableView;

   @FXML
   private TableColumn<Exam, Long> examIdColumn;

   @FXML
   private TableColumn<Exam, String> subjectNameColumn;

   @FXML
   private TableColumn<Exam, String> examCodeColumn;

   @FXML
   private TableColumn<Exam, String> examClassColumn;

   @FXML
   private TableColumn<Exam, String> examDateColumn;

   @FXML
   private TableColumn<Exam, String> examLocationColumn;

   @FXML
   private TableColumn<Exam, String> examDurationColumn;


   @FXML
   private TextField studentNumberField;

   @FXML
   private TextField examIdField;

   @FXML
   private TextField gradeField;


   @FXML
   private Button studentExamInsertButton;


   public Connection getConnection() {
      Connection conn;
      try {
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_system","postgres","simsoft");
         return conn;
      }
      catch (Exception e){
         e.printStackTrace();
         return null;
      }
   }

   public ObservableList<Student> getStudentList(){
      ObservableList<Student> studentlist = FXCollections.observableArrayList();
      Connection connection = getConnection();
      String query = "SELECT * FROM student_system ";
      Statement st;
      ResultSet rs;

      try {
         st = connection.createStatement();
         rs = st.executeQuery(query);
         Student student;
         while(rs.next()) {
            student = new Student(rs.getLong("id"),rs.getString("student_name"),rs.getString("birth_date"),rs.getString("school_class"),rs.getString("gender"),rs.getString("adress"),rs.getString("register_date"),rs.getString("grade"),null);
            studentlist.add(student);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return studentlist;
   }

   public ObservableList<Exam> getExamList(){
      ObservableList<Exam> examlist = FXCollections.observableArrayList();
      Connection connection = getConnection();
      String query = "SELECT * FROM exam ";
      Statement st;
      ResultSet rs;

      try {
         st = connection.createStatement();
         rs = st.executeQuery(query);
         Exam exam;
         while(rs.next()) {
            exam = new Exam(rs.getLong("id"),rs.getString("subject_name"),rs.getString("exam_code"),rs.getString("exam_class"),rs.getString("exam_date"),rs.getString("exam_location"),rs.getString("exam_duration"),null);
            examlist.add(exam);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return examlist;
   }
//   public ObservableList<StudentExams> getStudentExamsList(){
//      ObservableList<StudentExams> studentExamslist = FXCollections.observableArrayList();
//      Connection connection = getConnection();
//      String query = "SELECT * FROM student_exams ";
//      Statement st;
//      ResultSet rs;
//
//      try {
//         st = connection.createStatement();
//         rs = st.executeQuery(query);
//         StudentExams studentExams;
//         while(rs.next()) {
//            studentExams = new StudentExams(rs.getLong("id"),null,null,rs.getString("grade"));
//            studentExamslist.add(studentExams);
//         }
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      return studentExamslist;
//   }


   public void showStudents(){
      ObservableList<Student> studentList = getStudentList();

      idColumn.setCellValueFactory(new PropertyValueFactory<Student,Long>("id"));
      nameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("studentName"));
      birthDateColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("birthDate"));
      classColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("schoolClass"));
      genderColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
      addressColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("adress"));
      registerDateColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("registerDate"));
      gradeColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("grade"));

      studentTableView.setItems(studentList);
   }
   public void showExams(){
      ObservableList<Exam> examlist = getExamList();

      examIdColumn.setCellValueFactory(new PropertyValueFactory<Exam,Long>("id"));
      subjectNameColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("subjectName"));
      examCodeColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examCode"));
      examClassColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examClass"));
      examDateColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examDate"));
      examLocationColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examLocation"));
      examDurationColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("examDuration"));

      examTableView.setItems(examlist);
   }
//   public void showGrade(){
//      ObservableList<StudentExams> studentExamsList = getStudentExamsList();
//
//      gradeColumn.setCellValueFactory(new PropertyValueFactory<StudentExams,String>("grade"));
//
//     studentTableView.setItems(studentExamsList);
//   }




   @FXML
    public void initialize(){

      showStudents();
      showExams();

       this.studentInsertButton.setOnAction(actionEvent -> {
          Student student = new Student();
          student.setStudentName(nameField.getText());
          nameField.setText("");
          student.setBirthDate(birthDateField.getText());
          birthDateField.setText("");
          student.setGender(genderField.getText());
          genderField.setText("");
          student.setSchoolClass(schoolClassField.getText());
          schoolClassField.setText("");
          student.setAdress(addressField.getText());
          addressField.setText("");
          student.setRegisterDate(registerDateField.getText());
          registerDateField.setText("");
          studentRepository.save(student);
          showStudents();

       });

      this.examInsertButton.setOnAction(actionEvent -> {

         Exam exam = new Exam();
         exam.setSubjectName(subjectNameField.getText());
         subjectNameField.setText("");
         exam.setExamCode(examCodeField.getText());
         examCodeField.setText("");
         exam.setExamClass(examClassField.getText());
         examClassField.setText("");
         exam.setExamDate(examDateField.getText());
         examDateField.setText("");
         exam.setExamLocation(examLocationField.getText());
         examLocationField.setText("");
         exam.setExamDuration(examDurationField.getText());
         examDurationField.setText("");
         examRepository.save(exam);
         showExams();

      });
      this.studentExamInsertButton.setOnAction(actionEvent -> {
         Student student = new Student();
         StudentExams studentExams = new StudentExams();
         studentExams.setStudent(studentRepository.findById(Long.parseLong(studentNumberField.getText())).orElse(null));
         studentNumberField.setText("");
         studentExams.setExam(examRepository.findById(Long.parseLong(examIdField.getText())).orElse(null));
         examIdField.setText("");
         studentExams.setGrade(gradeField.getText());
         gradeField.setText("");
         student = studentRepository.findById(Long.parseLong(studentNumberField.getText())).get();
         student.setGrade(gradeField.getText());
         studentRepository.save(student);
         studentExamsRepository.save(studentExams);

         showStudents();

      });
//
   }


}
