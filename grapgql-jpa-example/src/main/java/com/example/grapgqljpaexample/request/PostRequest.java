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
public class PostRequest {
	private String title;
	private String description;
	private String category;
	private UUID authorId;
}
