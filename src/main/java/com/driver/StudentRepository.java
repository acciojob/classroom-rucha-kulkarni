package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;
@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> studentTeacherMap;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.studentTeacherMap = new HashMap<String, List<String>>();
    }
    public void saveStudent(Student student){
        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
    if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
        studentMap.put(student,studentMap.get(student));
        teacherMap.put(teacher,teacherMap.get(teacher));
        List<String> currentStudent = new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher)) currentStudent = studentTeacherMap.get(teacher);
        currentStudent.add(student);
        studentTeacherMap.put(student, currentStudent);
    }
    }

    public Student getStudent(String student){
        return studentMap.get(student);
    }

    public Teacher getTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> getStudentFromTeacher(String teacher){
        List<String> studentList = new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher)) studentList = studentTeacherMap.get(teacher);
        return studentList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
    List<String> students = new ArrayList<>();
    if(studentTeacherMap.containsKey(teacher)) {
        students = studentTeacherMap.get(teacher);

        for (String student : students) {
            if (studentMap.containsKey(student)) {
                studentMap.remove(student);
            }
        }
        studentTeacherMap.remove(teacher);
    }
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }

    }

    public void deleteAllTeachers(){
        HashSet<String> studentSet = new HashSet<>();
        for(String teacher : studentTeacherMap.keySet()){
            for(String student : studentTeacherMap.get(teacher)){
                studentSet.add(student);
            }
        }
        for(String student : studentSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
    }

}
