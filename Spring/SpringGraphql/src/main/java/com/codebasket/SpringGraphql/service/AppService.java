package com.codebasket.SpringGraphql.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.codebasket.SpringGraphql.datafetcher.AllBooksDataFetcher;
import com.codebasket.SpringGraphql.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class AppService {

	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	@Autowired
	private BookDataFetcher bookDataFetcher;

	@Value("classpath:graphql/books.graphql")
	private Resource resource;

	private GraphQL graphQL;

	public GraphQL getGraphQL() {
		return graphQL;
	}

	@PostConstruct
	private void loadSchema() throws IOException {
		// Get the graphql file
		File file = resource.getFile();
		// Parse Schema
		System.out.println("File Details:"+file);
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("allBooks", allBooksDataFetcher).dataFetcher("book", bookDataFetcher)).build();
	}
}
