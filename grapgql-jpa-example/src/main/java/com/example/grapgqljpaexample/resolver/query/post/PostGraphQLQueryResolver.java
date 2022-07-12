package com.example.grapgqljpaexample.resolver.query.post;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.grapgqljpaexample.response.PostResponse;
import com.example.grapgqljpaexample.service.PostService;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class PostGraphQLQueryResolver implements GraphQLQueryResolver{
	
	private final PostService postService;

	// constructor injection prefered over Setter Injection using @Autowired
	public PostGraphQLQueryResolver(PostService postService) {
		this.postService = postService;
	}

	public List<PostResponse> recentPostsWithoutDatabase(int count, int offset){
		//without database
		return Collections.singletonList(PostResponse
				.builder()
				.id(UUID.randomUUID())
				.title("Post Title")
				.description("Post Description")
				.category("Post Category")
				.build());
		
	}

	public List<PostResponse> recentPosts(int count, int offset){
		//without database
//		return Collections.singletonList(PostResponse
//				.builder()
//				.id(UUID.randomUUID())
//				.build());
		
		//with database
		return postService.recentPosts(count, offset);
	}
}
