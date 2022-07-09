package com.example.openapidocumentationexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest")
@Tag(name = "Hello", description = "Endpoints for Hello World")
public class HelloController {
	
	@GetMapping("/hello")
	 @Operation(
		        summary = "Hello world",
		        description = "Hello world message.",
		        tags = { "Hello" },
		        responses = {
		            @ApiResponse(
		                description = "Success",
		                responseCode = "200",
		                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
		            ),
		            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
		            @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
		        }
		        )
	public String helloWorld() {
		return "Hello World !";
	}

}