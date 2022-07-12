package com.example.grapgqljpaexample.resolver.query.author;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.grapgqljpaexample.TestApplication;
import com.example.grapgqljpaexample.util.FileReaderUtil;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
class AuthorGraphQLQueryResolverTest {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;
	@Test
	void shouldBeAbleToGetAuthorsData() throws IOException, JSONException {
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/author-query.graphqls");
		assertThat(graphQLResponse.isOk(), equalTo(true));
		assertEquals(FileReaderUtil.read("response/author-query.json"), graphQLResponse.getRawResponse().getBody(), true);
	}

}
