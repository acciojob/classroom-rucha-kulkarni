package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.saveStudentTeacherPair(student,teacher);
    }

    public Student findStudent(String student){
        return studentRepository.getStudent(student);
    }

    public Teacher findTeacher(String teacher){
        return studentRepository.getTeacher(teacher);
    }

    public List<String> findStudentFromTeacher(String teacher){
        return studentRepository.getStudentFromTeacher(teacher);
    }
    public List<String> findAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeachers();
    }
}
