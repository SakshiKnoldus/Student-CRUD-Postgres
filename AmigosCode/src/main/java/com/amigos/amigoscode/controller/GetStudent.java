package com.amigos.amigoscode.controller;

import com.amigos.amigoscode.entity.Student;
import com.amigos.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "get/student")
public class GetStudent {

    private final StudentService studentService;

    @Autowired
    public GetStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
