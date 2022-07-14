package com.example.graphqlclientheaderexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@SpringBootApplication
public class GraphqlClientHeaderExampleApplication {

	
	private static final Logger logger = LoggerFactory.getLogger(GraphqlClientHeaderExampleApplication.class);

	@Value("${read.header.example.ip}")
	private String graphQLReadHeaderExampleIp ;
	
	@Value("${read.header.example.port}")
	private int graphQLReadHeaderExamplePort ;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlClientHeaderExampleApplication.class, args);
	}
	@Bean
	public GraphQLWebClient graphQLWebClientReadHeaderExample() {
		ObjectMapper objectMapper =new ObjectMapper();
		String baseUrl = String.format("http://%s:%s/graphql",graphQLReadHeaderExampleIp, graphQLReadHeaderExamplePort);
		logger.info("graphQLReadHeaderExampleIp : {} , graphQLReadHeaderExamplePort : {}, baseUrl : {}", graphQLReadHeaderExampleIp, graphQLReadHeaderExamplePort, baseUrl);
		
		WebClient webClient = WebClient
				.builder()
				.baseUrl(baseUrl)
				.build();
		return GraphQLWebClient.newInstance(webClient, objectMapper);
	}

}
