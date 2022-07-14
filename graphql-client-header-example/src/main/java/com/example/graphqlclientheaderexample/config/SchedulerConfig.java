package com.example.graphqlclientheaderexample.config;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.graphqlclientheaderexample.response.MessageResponse;
import com.example.graphqlclientheaderexample.service.SchedulerService;

import graphql.kickstart.spring.webclient.boot.GraphQLError;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;

@Configuration
@EnableScheduling
public class SchedulerConfig {

private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);
@Autowired
private SchedulerService service;
@Scheduled(cron = "${scheduler.cron}")
public void cronJobScheduler() {
	logger.info("Scheduler called : {}", LocalDateTime.now());
	var firstName ="Kaushal";
	var lastName = "Sharma";
	GraphQLResponse graphQLResponseGreetingService =service.triggerReadHeaderGreetingService(firstName, lastName);
	String greetingMessageResponse = "";
	if(graphQLResponseGreetingService!=null && graphQLResponseGreetingService.getErrors()!=null) {
		List<GraphQLError> errors = graphQLResponseGreetingService.getErrors();
		if(errors!=null  && !errors.isEmpty()) {
			for(GraphQLError error: errors) {
				logger.error("Error occured : {}".concat(error.getMessage()));
			}
		}else {
			greetingMessageResponse= graphQLResponseGreetingService.get("greetingMessage", String.class);
			logger.info("graphQLResponse : {}",greetingMessageResponse);
		}
	}
	
	GraphQLResponse graphQLResponseMessageResponse =service.triggerMessageService();
	MessageResponse messageResponse = null;
	if(graphQLResponseMessageResponse!=null && graphQLResponseMessageResponse.getErrors()!=null) {
		List<GraphQLError> errors = graphQLResponseMessageResponse.getErrors();
		if(errors!=null  && !errors.isEmpty()) {
			for(GraphQLError error: errors) {
				logger.error("Error occured : {}".concat(error.getMessage()));
			}
		}else {
			messageResponse= graphQLResponseMessageResponse.get("messageResponse", MessageResponse.class);
			logger.info("graphQLResponseMessageResponse : {}",messageResponse);
		}
	}
}

}
