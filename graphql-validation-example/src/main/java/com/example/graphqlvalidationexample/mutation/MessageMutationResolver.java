package com.example.graphqlvalidationexample.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class MessageMutationResolver implements GraphQLMutationResolver {

	public UUID createMessage(UUID id, String title, Integer[] luckyNumbers, Integer value) {
		return UUID.randomUUID();
	}
}
