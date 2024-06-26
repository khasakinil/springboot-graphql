package com.springboot.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.query.entity.Student;
import com.springboot.query.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student getStudentById(long id) {
		return studentRepository.findById(id);
	}
}
