package com.example.graphqlenumexample.mutation;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlenumexample.constant.Category;
import com.example.graphqlenumexample.response.BookResponse;

import graphql.kickstart.tools.GraphQLMutationResolver;
@Component
public class BookGraphQLMutationResolver implements GraphQLMutationResolver{

	public BookResponse createBook(String name, Category category) {
		return BookResponse
				.builder()
				.id(UUID.randomUUID())
				.name(name)
				.category(category)
				.build();
	}
}