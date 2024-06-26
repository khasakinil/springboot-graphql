package com.springboot.query.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.query.entity.Subject;
import com.springboot.query.enums.SubjectNameFilter;
import com.springboot.query.response.StudentResponse;
import com.springboot.query.response.SubjectResponse;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
	public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse,
			SubjectNameFilter subjectNameFilter) {

		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				if (subjectNameFilter.name().equalsIgnoreCase("All")) {
					learningSubjects.add(new SubjectResponse(subject));
				}
				else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
					learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}
		return learningSubjects;
	}

	public String getFullName(StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}
