package com.springboot.query.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.query.entity.Subject;
import com.springboot.query.response.StudentResponse;
import com.springboot.query.response.SubjectResponse;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
	public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {

		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		if (studentResponse.getStudent().getLearningSubjects() != null) {

			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
		return learningSubjects;
	}

	public String getFullName(StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}
