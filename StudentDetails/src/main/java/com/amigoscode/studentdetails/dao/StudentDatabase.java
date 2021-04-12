package com.amigoscode.studentdetails.dao;

import com.amigoscode.studentdetails.entity.Student;
import com.amigoscode.studentdetails.entity.StudentUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class StudentDatabase {

    @Autowired
    private StudentRepository studentRepository;


    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.insert(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> updateStudentById(int id, StudentUpdatePayload studentUpdatePayload) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        boolean idExists = studentRepository.existsById(id);
        if(!idExists)
        {
            throw new IllegalStateException("Mentioned Id does not exists!");
        }
        updateStudent.ifPresent(s -> s.setName(studentUpdatePayload.getName()));
        updateStudent.ifPresent(s -> s.setEmail(studentUpdatePayload.getEmail()));
        updateStudent.ifPresent(s -> studentRepository.save(s));
        return updateStudent;
    }

    public void deleteStudentById(int id) {

        boolean idExists = studentRepository.existsById(id);

        if(!idExists) {
            throw new IllegalStateException("Mentioned student id does not exists!.");
        }
        studentRepository.deleteById(id);
    }
}
