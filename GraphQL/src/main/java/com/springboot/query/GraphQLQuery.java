package com.springboot.query;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class GraphQLQuery implements GraphQLQueryResolver {

	public String firstQuery() {
		System.out.println("firstQuery executed..!");
		return "GraphQL Query";
	}

	public String fullName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}
}
