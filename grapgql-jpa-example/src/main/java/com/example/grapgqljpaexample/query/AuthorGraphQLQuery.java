package com.example.grapgqljpaexample.query;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.response.AuthorResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class AuthorGraphQLQuery implements GraphQLQueryResolver{

	public List<AuthorResponse> authors() {
		return Collections.singletonList(AuthorResponse.builder().id(UUID.randomUUID()).name("kaushal").email("kaushal@gmail.com").build());
	}
	
}
