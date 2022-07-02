package com.example.grapgqljpaexample.query;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.response.PostResponse;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class PostFieldResolver implements GraphQLResolver<PostResponse> {
	public AuthorResponse author(PostResponse postResponse) {
		return AuthorResponse.builder().id(UUID.randomUUID()).name("kaushal").email("kaushal@gmail.com")
				.postId(postResponse.getAuthorId()).build();
	}
}
