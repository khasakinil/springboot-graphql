package com.springboot.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.query.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findById(long id);

}
