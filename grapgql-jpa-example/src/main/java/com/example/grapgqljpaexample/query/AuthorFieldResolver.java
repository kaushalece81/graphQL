package com.example.grapgqljpaexample.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.response.PostResponse;
import com.example.grapgqljpaexample.service.PostService;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorResponse> {
	@Autowired
	private PostService postService;
	public List<PostResponse> posts(AuthorResponse authorResponse) {
//		return Collections.singletonList(
//				PostResponse.builder().id(UUID.randomUUID()).title("post title")
//				.description("post description").category("general").authorId(authorResponse.getId()).build());
		//return from db
		return postService.getAllPostByAuthorId(authorResponse.getId());
	}
}
