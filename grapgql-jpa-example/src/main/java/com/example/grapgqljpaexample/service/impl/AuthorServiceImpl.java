package com.example.grapgqljpaexample.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grapgqljpaexample.model.Author;
import com.example.grapgqljpaexample.repository.AuthorRepository;
import com.example.grapgqljpaexample.request.AuthorRequest;
import com.example.grapgqljpaexample.response.AuthorResponse;
import com.example.grapgqljpaexample.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorResponse> getAuthors() {
		List<Author> findAll = authorRepository.findAll();
		return findAll.stream().map(author -> {
			return AuthorResponse
					.builder()
					.id(author.getId())
					.email(author.getEmail())
					.name(author.getName())
					.build();
		}).collect(Collectors.toList());
	}

	@Override
	public AuthorResponse getAuthorById(UUID authorId) {
		Optional<Author> findById = authorRepository.findById(authorId);
		Author author = findById.orElseThrow();
		return AuthorResponse
				.builder()
				.id(author.getId())
				.email(author.getEmail())
				.name(author.getName())
				.build();
	}

	@Override
	public Author createAuthor(AuthorRequest authorRequest) {
		 Author author = Author.builder().email(authorRequest.getEmail()).name(authorRequest.getName()).build();
		return authorRepository.saveAndFlush(author);
	}

}
