package com.example.graphqlvalidationexample.query;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlvalidationexample.response.MessageResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class HelloWorldGraphQLQuery implements GraphQLQueryResolver {

	public String helloWorld() {
		return "Hello World Example";
	}

	public MessageResponse getMessage() {
		return MessageResponse
				.builder()
				.id(UUID.randomUUID())
				.text("graphql is awesome")
				.build();
	}

}
