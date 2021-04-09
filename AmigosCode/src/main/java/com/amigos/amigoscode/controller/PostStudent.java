package com.amigos.amigoscode.controller;


import com.amigos.amigoscode.entity.Student;
import com.amigos.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "post/student")
public class PostStudent {

    private final StudentService studentService;

    @Autowired
    public PostStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<String> registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        return new ResponseEntity<String>("Added Student Successfully", HttpStatus.OK);

    }

}
