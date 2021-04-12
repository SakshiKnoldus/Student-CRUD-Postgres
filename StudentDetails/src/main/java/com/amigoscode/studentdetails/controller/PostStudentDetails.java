package com.amigoscode.studentdetails.controller;

import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "post/student")
public class PostStudentDetails {


    private final StudentService studentService;

    @Autowired
    public PostStudentDetails(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
         studentService.addNewStudent(student);
         return new ResponseEntity<String>("New student added Successfully!", HttpStatus.OK);
    }

}
