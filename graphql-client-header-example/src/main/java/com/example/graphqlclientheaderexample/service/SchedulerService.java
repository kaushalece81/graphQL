package com.example.graphqlclientheaderexample.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphqlclientheaderexample.response.MessageResponse;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import reactor.core.publisher.Mono;
@Service
public class SchedulerService {

	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
	private static final String QUERY_GREETING_MESSAGE = """
			query greetingMessage($firstName : String!, $lastName : String!){
			greetingMessage(firstName : $firstName, lastName : $lastName)
			}
			""";
	private static final String QUERY_MESSAGE = """
			query{
				messageResponse{
								id
								text
								}
				}
			""";
	
	@Autowired
	private GraphQLWebClient graphQLWebClientGreetingHeaderExample;

	public GraphQLResponse triggerReadHeaderGreetingService(String firstName, String lastName) {
		Map<String, Object> greetingMessageVariables =new HashMap<>();
		greetingMessageVariables.put("firstName", firstName);
		greetingMessageVariables.put("lastName", lastName);
		GraphQLRequest graphQLRequest = GraphQLRequest
				.builder()
				.query(QUERY_GREETING_MESSAGE)
				.variables(greetingMessageVariables)
				.header("correlation-id", UUID.randomUUID().toString())
				.header("user-name", "Kaushlender")
				.build();
		// blocking call
		GraphQLResponse graphQLResponse = graphQLWebClientGreetingHeaderExample.post(graphQLRequest).block();
		//non blocking call
		graphQLWebClientGreetingHeaderExample.post(graphQLRequest)
		.subscribe(response-> {
			printGreetingMessage(response);
		});
		logger.info("triggerReadHeaderGreetingService : {} ");
		return graphQLResponse;
	}

	private void printGreetingMessage(GraphQLResponse a) {
		String successMessage=a.get("greetingMessage", String.class);
		logger.info("successMessage==================={}",successMessage);
	}

	public GraphQLResponse triggerMessageService() {
		GraphQLRequest graphQLRequest = GraphQLRequest
				.builder()
				.query(QUERY_MESSAGE)
				.header("correlation-id", UUID.randomUUID().toString())
				.header("user-name", "Kaushlender")
				.build();
		GraphQLResponse graphQLResponse = graphQLWebClientGreetingHeaderExample.post(graphQLRequest).block();
		logger.info("triggerMessageService ");
		return graphQLResponse;
	}

}
