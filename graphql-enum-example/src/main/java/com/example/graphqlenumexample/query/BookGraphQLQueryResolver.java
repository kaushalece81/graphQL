package com.example.graphqlenumexample.query;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlenumexample.constant.Category;
import com.example.graphqlenumexample.response.BookResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class BookGraphQLQueryResolver implements GraphQLQueryResolver{

	public BookResponse book() {
		return BookResponse
				.builder()
				.id(UUID.randomUUID())
				.name("Java8 Example")
				.category(Category.COMEDY)
				.build();
	}
}