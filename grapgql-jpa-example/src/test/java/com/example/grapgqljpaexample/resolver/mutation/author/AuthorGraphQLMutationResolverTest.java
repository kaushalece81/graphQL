package com.example.grapgqljpaexample.resolver.mutation.author;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.grapgqljpaexample.TestApplication;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
class AuthorGraphQLMutationResolverTest {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;
	@Test
	void shouldBeAbleToCreateAuthor() throws IOException, JSONException {
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/create-author-mutation.graphqls");
		assertThat(graphQLResponse.isOk(), equalTo(true));
		String uuid = graphQLResponse.get("$.data.createAuthor");
		assertThat(uuid, is(notNullValue()));
	}

}
