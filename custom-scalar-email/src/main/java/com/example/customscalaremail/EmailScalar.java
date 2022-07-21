package com.example.customscalaremail;

import java.util.regex.Pattern;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Configuration
public class EmailScalar {
	//https://www.graphql-java.com/documentation/scalars/
	 @Bean
	 GraphQLScalarType email(){
		 return GraphQLScalarType.newScalar()
				 // this should match with scalar Email defined scalar type
		            .name("Email")
		            .description("A custom scalar that handles emails")
		            .coercing(new Coercing() {
		            	// serialize for output
		                @Override
		                public Object serialize(Object dataFetcherResult) {
		                    return serializeEmail(dataFetcherResult);
		                }
		                // parse value for input if value is passed as GraphQL variable
		                //customer (email : $email)
		                @Override
		                public Object parseValue(Object input) {
		                    return parseEmailFromVariableValue(input);
		                }
		                // parse literal for input if value is passed without GraphQL variable
		                //customer (email : "kaushal@gmail.com")
		                @Override
		                public Object parseLiteral(Object input) {
		                    return parseEmailFromLiteral(input);
		                }
		            })
		            .build();
	 }

    private static boolean isValidEmail(String possibleEmailValue) {
        return Pattern.matches( "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", possibleEmailValue);
    }

    private static Object serializeEmail(Object dataFetcherResult) {
        String possibleEmailValue = String.valueOf(dataFetcherResult);
        if (isValidEmail(possibleEmailValue)) {
            return possibleEmailValue;
        } else {
            throw new CoercingSerializeException("Unable to serialize " + possibleEmailValue + " as an email address");
        }
    }

    private static Object parseEmailFromVariableValue(Object input) {
        if (input instanceof String) {
            String possibleEmailValue = input.toString();
            if (isValidEmail(possibleEmailValue)) {
                return possibleEmailValue;
            }
        }
        throw new CoercingParseValueException("Unable to parse variable value " + input + " as an email address");
    }

    private static Object parseEmailFromLiteral(Object input) {
        if (input instanceof StringValue stringValue) {
            String possibleEmailValue = stringValue.getValue();
            if (isValidEmail(possibleEmailValue)) {
                return possibleEmailValue;
            }
        }
        throw new CoercingParseLiteralException(
                "Value is not any email address : '" + String.valueOf(input) + "'"
        );
    }
}