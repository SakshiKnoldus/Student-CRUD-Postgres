package com.amigoscode.studentdetails.dao;

import com.amigoscode.studentdetails.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
