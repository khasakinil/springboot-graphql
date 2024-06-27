package com.springboot.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springboot.mutation.request.CreateStudentRequest;
import com.springboot.query.response.StudentResponse;
import com.springboot.query.service.StudentService;

@Component
public class GraphQLMutation implements GraphQLMutationResolver{

	@Autowired
	StudentService studentService;
	
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		return new StudentResponse(studentService.createStudent(createStudentRequest));
	}
}
