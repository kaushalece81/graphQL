package com.example.grapgqljpaexample.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
	private UUID id;
	private String name;
	private String email;
	private UUID  postId;
}
