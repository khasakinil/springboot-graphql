package com.springboot.query.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mutation.request.CreateStudentRequest;
import com.springboot.mutation.request.CreateSubjectRequest;
import com.springboot.query.entity.Address;
import com.springboot.query.entity.Student;
import com.springboot.query.entity.Subject;
import com.springboot.query.repository.AddressRepository;
import com.springboot.query.repository.StudentRepository;
import com.springboot.query.repository.SubjectRepository;
import com.springboot.query.response.SubjectResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SubjectRepository subjectRepository;

	public Student getStudentById(long id) {
		return studentRepository.findById(id);
	}

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		student.setAddress(address);
		student = studentRepository.save(student);

		List<Subject> subjectsList = new ArrayList<Subject>();

		if (createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest : createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);

				subjectsList.add(subject);
			}
			subjectRepository.saveAll(subjectsList);
		}

		student.setLearningSubjects(subjectsList);
		return student;
	}
}
