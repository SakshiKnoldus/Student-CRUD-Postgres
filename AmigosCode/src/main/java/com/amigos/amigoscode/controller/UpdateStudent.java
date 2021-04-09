package com.amigos.amigoscode.controller;

import com.amigos.amigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "update/student")
public class UpdateStudent {

    private final StudentService studentService;

    @Autowired
    public UpdateStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping(path = "{studentId}")
   public @ResponseBody
    ResponseEntity<String> updateStudent(
       @PathVariable("studentId") Long studentId,
       @RequestParam(required = false) String name,
       @RequestParam(required = false) String email) {

        studentService.updateStudent(studentId, name, email);
        return new ResponseEntity<String>("Updated Student Successfully", HttpStatus.OK);
    }

}
