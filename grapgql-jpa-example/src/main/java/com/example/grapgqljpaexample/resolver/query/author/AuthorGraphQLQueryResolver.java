package com.example.grapgqljpaexample.resolver.query.author;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.service.AuthorService;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class AuthorGraphQLQueryResolver implements GraphQLQueryResolver{

	@Autowired
	private AuthorService authorService;
	
	public List<AuthorResponse> authors() {
		// return from database
		return authorService.getAuthors();
	}
	
	public List<AuthorResponse> authorsWithoutDatabase() {
		return Collections.singletonList(AuthorResponse.builder().id(UUID.randomUUID()).name("kaushal").email("kaushal@gmail.com").build());
	}
	//with database
	public AuthorResponse authorById(UUID uuid) {
		return authorService.getAuthorById(uuid);
	}
	
}
