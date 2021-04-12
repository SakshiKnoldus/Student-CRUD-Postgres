package com.amigoscode.studentdetails.controller;

import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "delete/student")
public class DeleteStudentDetails {

    private final StudentService studentService;

    @Autowired
    public DeleteStudentDetails(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
         studentService.deleteStudentById(id);
         return new ResponseEntity<>("Deleted student record Successfully!", HttpStatus.OK);
    }


}
