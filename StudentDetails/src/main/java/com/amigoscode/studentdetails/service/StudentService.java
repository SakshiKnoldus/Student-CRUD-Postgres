package com.amigoscode.studentdetails.service;

import com.amigoscode.studentdetails.dao.StudentDatabase;
import com.amigoscode.studentdetails.dao.StudentRepository;
import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.entity.StudentUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentDatabase studentDatabase;

    public Collection<Student> getStudents() {

        return studentDatabase.getAllStudents();
    }

    public Student addNewStudent(Student student) {

        return studentDatabase.addStudent(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentDatabase.getStudentById(id);
    }

    public Optional<Student> updateStudentById(int id, StudentUpdatePayload studentUpdatePayload) {
        return studentDatabase.updateStudentById(id, studentUpdatePayload);
    }

    public void deleteStudentById(int id) {
         studentDatabase.deleteStudentById(id);
    }
}
