package com.example.grapgqljpaexample.resolver.mutation.author;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.model.Author;
import com.example.grapgqljpaexample.request.AuthorRequest;
import com.example.grapgqljpaexample.service.AuthorService;

import graphql.kickstart.tools.GraphQLMutationResolver;
@Component
public class AuthorGraphQLMutationResolver implements GraphQLMutationResolver
{
	private final AuthorService authorService;
	
	public AuthorGraphQLMutationResolver(AuthorService authorService) {
		this.authorService = authorService;
	}
	public UUID createAuthorWithoutDatabase(AuthorRequest authorRequest) {
		return UUID.randomUUID();
	}
	//with database
	public UUID createAuthor(AuthorRequest authorRequest) {
		Author author = authorService.createAuthor(authorRequest);
		 return author.getId();
	}
}
