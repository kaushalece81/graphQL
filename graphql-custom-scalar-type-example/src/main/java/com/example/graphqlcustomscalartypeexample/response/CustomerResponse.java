package com.example.graphqlcustomscalartypeexample.response;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerResponse {
	private LocalDate birthDate;
	private OffsetTime workStartTime;
	private OffsetDateTime bornAt;
	private String phoneNumber;
	private String profileLink;
}
