package com.amigoscode.studentdetails.controller;

import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.entity.StudentUpdatePayload;
import com.amigoscode.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "update/student")
public class UpdateStudentDetails {

    private final StudentService studentService;

    @Autowired
    public UpdateStudentDetails(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable("id") int id, @RequestBody StudentUpdatePayload
        studentUpdatePayload) {
        studentService.updateStudentById(id, studentUpdatePayload);
        return new ResponseEntity<>("Updated student record Successfully!", HttpStatus.OK);

    }

}
