package com.example.graphqlvalidationexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.graphqlvalidationexample.directive.UppercaseDirective;

import graphql.kickstart.tools.boot.SchemaDirective;

@Component
public class CustomDirectiveConfig {

    @Bean
    public SchemaDirective upperCaseDirective() {
        return new SchemaDirective("Uppercase", new UppercaseDirective());
    }
}