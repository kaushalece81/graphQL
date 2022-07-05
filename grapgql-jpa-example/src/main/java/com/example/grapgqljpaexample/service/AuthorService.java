package com.example.grapgqljpaexample.service;

import java.util.List;
import java.util.UUID;

import com.example.grapgqljpaexample.response.AuthorResponse;

public interface AuthorService {
	List<AuthorResponse> getAuthors();

	AuthorResponse getAuthorById(UUID authorId);
}
