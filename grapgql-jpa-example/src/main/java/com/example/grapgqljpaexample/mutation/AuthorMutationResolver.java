package com.example.grapgqljpaexample.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.request.AuthorRequest;

import graphql.kickstart.tools.GraphQLMutationResolver;
@Component
public class AuthorMutationResolver implements GraphQLMutationResolver
{
	public UUID createAuthorWithoutDatabase(AuthorRequest authorRequest) {
		return UUID.randomUUID();
	}
	
	public UUID createAuthor(AuthorRequest authorRequest) {
		return UUID.randomUUID();
	}
}
