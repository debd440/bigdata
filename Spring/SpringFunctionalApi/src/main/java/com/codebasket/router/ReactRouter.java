package com.codebasket.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codebasket.handler.StudentHandler;

@Configuration
public class ReactRouter {

	@Autowired
	private StudentHandler studentHandler;

	@Bean
	public RouterFunction<ServerResponse> route() {

		System.out.println("*********************Accepting Router**************************");
		return RouterFunctions.route(GET("/api/v2/react/student/{id}"), studentHandler::getStudent)
				.andRoute(GET("/api/v2/react/student"), studentHandler::getStudentList)
				.andRoute(POST("/api/v2/react/student"), studentHandler::saveStudent)
				.andRoute(GET("/api/v2/react/query-param"), studentHandler::queryParam)
				.andRoute(GET("/api/v2/react/header"), studentHandler::header)
				.andRoute(POST("/api/v2/react/multi-value"), studentHandler::multiStudent)
				.andRoute(DELETE("/api/v2/react/delete"), studentHandler::deleteData);
	}
}
