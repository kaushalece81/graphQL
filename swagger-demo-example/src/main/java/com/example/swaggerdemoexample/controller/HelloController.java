package com.example.swaggerdemoexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest")
@Api(value = "HelloWorld Resource")
public class HelloController {
	 @ApiOperation(value = "Returns Hello World message")
	    @ApiResponses(
	            value = {
	                    @ApiResponse(code = 100, message = "100 is the message"),
	                    @ApiResponse(code = 200, message = "Successful Hello World")
	            }
	    )
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World !";
	}

}
