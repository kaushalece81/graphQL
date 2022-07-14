package com.example.graphqlreadheaderexample.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import org.springframework.stereotype.Component;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;

@Component
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {
    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        String correlationId = httpServletRequest.getHeader("correlation-id");

        DefaultGraphQLServletContext servletContext = DefaultGraphQLServletContext.createServletContext()
                .with(httpServletRequest)
                .with(httpServletResponse)
                .build();

        return new CustomGraphQLContext(correlationId, servletContext);
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext()
                .with(session)
                .with(handshakeRequest)
                .build();
    }

    @Override
    public GraphQLContext build() {
        throw new IllegalStateException("UnSupported");
    }
}
