package com.amigoscode.studentdetails.controller;

import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "get/student")
public class ReadStudentDetails {

    private final StudentService studentService;

    @Autowired
    public ReadStudentDetails(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getStudents() {
        return studentService.getStudents();
    }
}
