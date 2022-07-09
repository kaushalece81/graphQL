package com.example.graphqlexceptionexample.exception;

import java.util.List;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class ResourceNotFoundException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 6345535728177600667L;

	private String message;
	
	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorClassification getErrorType() {
		return ErrorType.DataFetchingException;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public StackTraceElement[] getStackTrace() {
		//return super.getStackTrace();
		return null;
	}
}
