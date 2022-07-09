package com.example.graphqlexceptionexample.query;

import org.springframework.stereotype.Component;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class BasicGraphQLQuery implements GraphQLQueryResolver{

	public String helloWorld() {
		if(true) {
		//throw new ResourceNotFoundException("Author Not found");
		//throw new GraphQLException("Client Not Available");
		throw new RuntimeException("Internal server error Occured");
	}
		return "Hello World Example";
	}
	
	
}
