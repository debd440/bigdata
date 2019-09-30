package com.codebasket.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codebasket.model.StudentTo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	static Map<String, StudentTo> studentList = new HashMap<>();
	static {

		studentList.put("1", new StudentTo("1", "StudentTo 1"));
		studentList.put("2", new StudentTo("2", "StudentTo 2"));
		studentList.put("3", new StudentTo("3", "StudentTo 3"));
		studentList.put("4", new StudentTo("4", "StudentTo 4"));
		studentList.put("5", new StudentTo("5", "StudentTo 5"));
		studentList.put("6", new StudentTo("6", "StudentTo 6"));
		studentList.put("7", new StudentTo("7", "StudentTo 7"));
		studentList.put("8", new StudentTo("8", "StudentTo 8"));
		studentList.put("9", new StudentTo("9", "StudentTo 9"));
		studentList.put("10", new StudentTo("10", "StudentTo 10"));
	}

	private Mono<StudentTo> result(String id) {

		Mono<StudentTo> item = Mono.justOrEmpty(studentList.get(id));
		return item;
	}

	private Flux<StudentTo> result() {
		return Flux.fromStream(studentList.values().stream());
	}

	private Mono<Void> saveStudent(Mono<StudentTo> StudentTo) {
		Mono<StudentTo> studentToMono = StudentTo.doOnNext(value -> {
			studentList.put(("" + (studentList.keySet().size() + 1)), value);
		});
		return studentToMono.then();
	}

	// Expose Public Method
	public Mono<ServerResponse> getStudentList(ServerRequest request) {

		System.out.println("*********************Accepting Handler**************************");
		Flux<StudentTo> StudentTo = result();
		return ServerResponse.ok().body(StudentTo, StudentTo.class);
	}

	// Path Param
	public Mono<ServerResponse> getStudent(ServerRequest request) {
		System.out.println("*********************Accepting Handler**************************");
		String id = request.pathVariable("id");
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<StudentTo> studentToMono = result(id);
		return studentToMono.flatMap(StudentTo -> ServerResponse.ok().contentType(APPLICATION_JSON)
				.body(BodyInserters.fromObject(StudentTo))).switchIfEmpty(notFound);
	}

	// Post Request
	public Mono<ServerResponse> saveStudent(ServerRequest request) {
		System.out.println("in create StudentTo");
		Mono<StudentTo> studentTo = request.bodyToMono(StudentTo.class);
		saveStudent(studentTo);
		return ServerResponse.ok().build();
	}

	//http://localhost:8080/api/v2/react/query-param?name=B2C
	// Query Param
	public Mono<ServerResponse> queryParam(ServerRequest request) {
		System.out.println("*********************Accepting Handler**************************");
		Optional<String> name = request.queryParam("name");
		return ServerResponse.ok().body(BodyInserters.fromObject("Query Param Received: " + name.get()));
	}

	// Headers
	public Mono<ServerResponse> header(ServerRequest request) {
		System.out.println("in Header Service: " + request.methodName());
		List<String> header = request.headers().header("X-APP-ID");

		return ServerResponse.ok().body(BodyInserters.fromObject("Header Param Received: " + header.get(0)));
	}

}
