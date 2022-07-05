package com.example.grapgqljpaexample.query;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.exception.ResourceNotFoundException;
import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.service.AuthorService;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class AuthorGraphQLQuery implements GraphQLQueryResolver{

	@Autowired
	private AuthorService authorService;
	public List<AuthorResponse> authors() {
//		if(true) {
//			throw new ResourceNotFoundException("Author Not found");
//			//throw new GraphQLException("Client Not Available");
//			//throw new RuntimeException("Internal server error Occured");
//		}
		
		//return Collections.singletonList(AuthorResponse.builder().id(UUID.randomUUID()).name("kaushal").email("kaushal@gmail.com").build());
		
		// return from database
		return authorService.getAuthors();
	}
	
}
