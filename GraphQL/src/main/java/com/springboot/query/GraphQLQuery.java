package com.springboot.query;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class GraphQLQuery implements GraphQLQueryResolver {

	public String firstQuery() {
		return "GraphQL Query";
	}
}
