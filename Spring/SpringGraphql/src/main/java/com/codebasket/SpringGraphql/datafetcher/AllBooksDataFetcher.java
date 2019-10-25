package com.codebasket.SpringGraphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebasket.SpringGraphql.repository.Book;
import com.codebasket.SpringGraphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Service
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
		return bookRepository.findAll();
	}
}
