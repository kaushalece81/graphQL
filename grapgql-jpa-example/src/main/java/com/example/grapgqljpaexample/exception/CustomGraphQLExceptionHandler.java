package com.example.grapgqljpaexample.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

@Component
public class CustomGraphQLExceptionHandler implements GraphQLErrorHandler {

	
	private static final Logger loggger = LoggerFactory.getLogger(CustomGraphQLExceptionHandler.class);

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		return errors.stream().map(this::getError).collect(Collectors.toList());
	}

	private GraphQLError getError(GraphQLError graphQLerror) {
		if (graphQLerror instanceof ExceptionWhileDataFetching) {
			ExceptionWhileDataFetching ex = (ExceptionWhileDataFetching) graphQLerror;
			if (ex.getException() instanceof GraphQLError) {
				return (GraphQLError) ex.getException();
			}
		}
		else {
			loggger.error("GraphQLError : {}",graphQLerror);
		}
		return graphQLerror;
	}

}
