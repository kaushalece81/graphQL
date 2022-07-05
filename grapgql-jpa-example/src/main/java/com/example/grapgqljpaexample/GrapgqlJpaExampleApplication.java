package com.example.grapgqljpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GrapgqlJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrapgqlJpaExampleApplication.class, args);
	}

}
