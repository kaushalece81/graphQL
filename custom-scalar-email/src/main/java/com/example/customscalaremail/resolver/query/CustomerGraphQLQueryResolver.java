package com.example.customscalaremail.resolver.query;

import org.springframework.stereotype.Component;

import com.example.customscalaremail.response.CustomerResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class CustomerGraphQLQueryResolver implements GraphQLQueryResolver{

	public CustomerResponse customer(String email) {
		return CustomerResponse
				.builder()
				.email(email)
				.build();
	}
}