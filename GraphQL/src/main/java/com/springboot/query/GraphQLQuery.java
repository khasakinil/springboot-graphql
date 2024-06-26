package com.springboot.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springboot.query.response.StudentResponse;
import com.springboot.query.service.StudentService;

@Component
public class GraphQLQuery implements GraphQLQueryResolver {

	@Autowired
	private StudentService studentService;

	public String firstQuery() {
		System.out.println("firstQuery executed..!");
		return "GraphQL Query";
	}

	public String fullName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	public String fullNameWithJsonRequest(FullNameRequest request) {
		return request.getFirstName() + " " + request.getLastName();
	}

	public StudentResponse student(long id) {
		return new StudentResponse(studentService.getStudentById(id));
	}
}
