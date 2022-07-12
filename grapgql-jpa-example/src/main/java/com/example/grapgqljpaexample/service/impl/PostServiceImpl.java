package com.example.grapgqljpaexample.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.grapgqljpaexample.model.Author;
import com.example.grapgqljpaexample.model.Post;
import com.example.grapgqljpaexample.repository.AuthorRepository;
import com.example.grapgqljpaexample.repository.PostRepository;
import com.example.grapgqljpaexample.request.PostRequest;
import com.example.grapgqljpaexample.response.PostResponse;
import com.example.grapgqljpaexample.service.PostService;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<PostResponse> getAllPostByAuthorId(UUID authorId) {
		List<Post> findAllByAuthor_Id = postRepository.findAllByAuthor_Id(authorId);
		return findAllByAuthor_Id.stream().map(post -> {
			return PostResponse
					.builder()
					.id(post.getId())
					.authorId(authorId)
					.description(post.getDescription())
					.title(post.getTitle())
					.category(post.getCategory())
					.build();
		}).collect(Collectors.toList());
	}

	// Pagination example
	@Override
	public List<PostResponse> recentPosts(int count, int offset) {
		Pageable pageable = PageRequest.of(offset, count);
		Page<Post> findAll = postRepository.findAll(pageable);
		return findAll
				.stream()
				.map(post -> {
			return PostResponse
					.builder()
					.id(post.getId())
					.authorId(post.getAuthor().getId())
					.description(post.getDescription())
					.title(post.getTitle())
					.category(post.getCategory())
					.build();
		}).collect(Collectors.toList());
	}

	@Override
	public Post createPost(PostRequest postRequest) {
		Optional<Author> author = authorRepository.findById(postRequest.getAuthorId());
		if(!author.isPresent()) {
			throw new RuntimeException("Author Id does not exist");
		}
		Post post = Post.builder()
				.title(postRequest.getTitle())
				.description(postRequest.getDescription())
				.category(postRequest.getCategory())
				.author(author.get())
				.build();
		return postRepository.saveAndFlush(post);
	}

}
