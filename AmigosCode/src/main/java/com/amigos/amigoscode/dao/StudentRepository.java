package com.amigos.amigoscode.dao;

import com.amigos.amigoscode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*
Interface responsible for data access
 */
@Repository
public interface StudentRepository extends
    JpaRepository<Student, Long> {

    //SELECT * FROM student WHERE email = whatever we pass
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
