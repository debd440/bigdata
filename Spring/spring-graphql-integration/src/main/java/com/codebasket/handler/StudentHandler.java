package com.codebasket.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.codebasket.model.StudentTo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;

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
		Mono<StudentTo> StudentToMono = StudentTo.doOnNext(value -> {
			studentList.put(("" + (studentList.keySet().size() + 1)), value);
		});
		return StudentToMono.then();
	}

	// Expose Public Method
	public Mono<ServerResponse> getStudentList(ServerRequest request) {

		System.out.println("*********************Accepting Handler**************************");
		Flux<StudentTo> StudentTo = result();
		return ServerResponse.ok().body(StudentTo, StudentTo.class);
	}

	public Mono<ServerResponse> getStudent(ServerRequest request) {
		System.out.println("*********************Accepting Handler**************************");
		String id = request.pathVariable("id");
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<StudentTo> StudentToMono = result(id);
		return StudentToMono.flatMap(StudentTo -> ServerResponse.ok().contentType(APPLICATION_JSON)
				.body(BodyInserters.fromObject(StudentTo))).switchIfEmpty(notFound);
	}

	public Mono<ServerResponse> saveStudent(ServerRequest request) {
		System.out.println("in create StudentTo");
		Mono<StudentTo> StudentTo = request.bodyToMono(StudentTo.class);
		return ServerResponse.ok().build(saveStudent(StudentTo));
	}

}
