/*
 * Copyright 2022, Kaushal Company
 *
 * @author kaushlender sharma
 *
 * BasicGraphQLQuery.java
 */
package com.example.graphqlhelloworld.query;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlhelloworld.response.MessageResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class BasicGraphQLQuery implements GraphQLQueryResolver {

    private String TEXT = "test";

    public String helloWorld() {
        return "Hello World Example";
    }

    public String greetingMessage(String firstName, String lastName) {
        return String.format("Hello %s  %s", firstName, lastName);
    }

    public MessageResponse getMessageResponse() {
        return MessageResponse.builder().id(UUID.randomUUID()).text("GraphQL is Awesome").build();
    }

    public List<Integer> getRollDice() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    public List<String> getTossCoin() {
        return Arrays.asList("HEAD", "TAIL");
    }
}
