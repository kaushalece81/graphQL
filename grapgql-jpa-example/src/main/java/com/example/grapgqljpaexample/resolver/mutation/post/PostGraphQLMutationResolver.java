package com.example.grapgqljpaexample.resolver.mutation.post;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.model.Post;
import com.example.grapgqljpaexample.request.PostRequest;
import com.example.grapgqljpaexample.service.PostService;

import graphql.kickstart.tools.GraphQLMutationResolver;
@Component
public class PostGraphQLMutationResolver implements GraphQLMutationResolver
{
	private final PostService postService;
	
	public PostGraphQLMutationResolver(PostService postService) {
		this.postService = postService;
	}
	public UUID createPostWithoutDatabase(PostRequest postRequest) {
		return UUID.randomUUID();
	}
	//with database
	public UUID createPost(PostRequest postRequest) {
		 Post postCreated = postService.createPost(postRequest);
		 return postCreated.getId();
	}
}
