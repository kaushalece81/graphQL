package com.example.grapgqljpaexample.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
	private UUID id;
	private String name;
	private String email;
	private UUID  postId;
}
