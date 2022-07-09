package com.example.graphqlexceptionexample.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
@Component
public class GraphQLExceptionHandler {
	@ExceptionHandler(GraphQLException.class)
	public ThrowableGraphQLError handle(GraphQLException e) {
		return new ThrowableGraphQLError(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ThrowableGraphQLError handle(RuntimeException e) {
		return new ThrowableGraphQLError(e);
	}
}
