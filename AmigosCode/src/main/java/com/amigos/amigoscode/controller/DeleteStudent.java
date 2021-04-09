package com.amigos.amigoscode.controller;

import com.amigos.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "delete/student")
public class DeleteStudent {

    private final StudentService studentService;

    @Autowired
    public DeleteStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping(path = "{studentId}")
    public @ResponseBody
    ResponseEntity<String> deleteStudent(@PathVariable ("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<String>("Deleted Student Successfully", HttpStatus.OK);
    }




}
