package com.example.graphqlcustomscalartypeexample.config;

import java.util.regex.Pattern;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.Scalars;
import graphql.language.StringValue;
import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

@Configuration
public class ScalarTypeConfig {
	@Bean
	GraphQLScalarType date() {
		return ExtendedScalars.Date;
	}

	@Bean
	GraphQLScalarType dateTime() {
		return ExtendedScalars.DateTime;
	}

	@Bean
	GraphQLScalarType time() {
		return ExtendedScalars.Time;
	}

	// refer site for regex pattern https://regex101.com/library serach phone number
	// open regex in editor
	// ^([+]?\d{1,2}[-\s]?|)\d{3}[-\s]?\d{3}[-\s]?\d{4}$
	// +1 504 595 1378
	@Bean
	GraphQLScalarType phoneNumber() {
		return ExtendedScalars.newRegexScalar("PhoneNumber")
				.addPattern(Pattern.compile("^([+]?\\d{1,2}[-\\s]?|)\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{4}$")).build();
	}

	@Bean
	GraphQLScalarType socialMediaLink() {
		return ExtendedScalars.newAliasedScalar("SocialMediaLink").aliasedScalar(Scalars.GraphQLString).build();
	}
	
//	@Bean
//	public GraphQLScalarType bytesScalar() {
//		  return GraphQLScalarType.newScalar()
//		      .name("Bytes")
//		      .description("A Bytes scalar")
//		      .coercing(()
//		      //.coercing(BYTES_COERCING)
//		      .build();
//		}
		 
	
}
