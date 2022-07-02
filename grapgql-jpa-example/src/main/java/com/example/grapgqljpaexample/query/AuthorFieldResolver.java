package com.example.grapgqljpaexample.query;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.response.PostResponse;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorResponse> {
	public List<PostResponse> posts(AuthorResponse authorResponse) {
		return Collections.singletonList(PostResponse.builder().id(UUID.randomUUID()).title("post title")
				.description("post description").category("general").authorId(authorResponse.getId()).build());
	}
}
