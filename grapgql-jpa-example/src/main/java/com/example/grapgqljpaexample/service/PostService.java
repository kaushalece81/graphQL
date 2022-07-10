package com.example.grapgqljpaexample.service;

import java.util.List;
import java.util.UUID;

import com.example.grapgqljpaexample.response.PostResponse;

public interface PostService {
	public List<PostResponse> getAllPostByAuthorId(UUID authorId);

	public List<PostResponse> recentPosts(int count, int offset);
}
