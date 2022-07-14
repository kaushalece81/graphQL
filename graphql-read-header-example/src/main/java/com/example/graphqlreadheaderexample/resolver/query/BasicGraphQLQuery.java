package com.example.graphqlreadheaderexample.resolver.query;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.graphqlreadheaderexample.context.CustomGraphQLContext;
import com.example.graphqlreadheaderexample.response.MessageResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
@Component
public class BasicGraphQLQuery implements GraphQLQueryResolver{

private static final Logger logger = LoggerFactory.getLogger(BasicGraphQLQuery.class);

	public String helloWorld() {
		return "Hello World Example";
	}
	
	public String greetingMessage(String firstName, String lastName, DataFetchingEnvironment dataFetchingEnvironment) {
		CustomGraphQLContext context = dataFetchingEnvironment.getContext();
		String correlationId = context.getCorrelationId();
		logger.info("Header data correlationId: {}", correlationId);
		return String.format("Hello %s  %s", firstName, lastName) ;
	}
	
	public MessageResponse getMessageResponse() {
		return MessageResponse.builder().id(UUID.randomUUID()).text("GraphQL is Awesome").build();
	}
}
