package com.example.graphqlcustomscalartypeexample.resolver.query;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

import org.springframework.stereotype.Component;

import com.example.graphqlcustomscalartypeexample.response.CustomerResponse;

import graphql.kickstart.tools.GraphQLQueryResolver;
@Component
public class CustomerGraphQLQueryResolver implements GraphQLQueryResolver{

	public CustomerResponse customer(String phoneNumber) {
		return CustomerResponse
				.builder()
				.birthDate(LocalDate.of(1981, 11, 15))
				.workStartTime(OffsetTime.now())
				.bornAt(OffsetDateTime.now())
				.phoneNumber(phoneNumber)
				.profileLink("https://regex101.com/r/rL2lD5/1")
				.build();
	}
}
