package com.example.graphqlenumexample.response;

import java.util.UUID;

import com.example.graphqlenumexample.constant.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookResponse {
	private UUID id;
	private String name;
	private Category category;
}
