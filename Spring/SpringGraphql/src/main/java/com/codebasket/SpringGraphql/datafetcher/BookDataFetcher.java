package com.codebasket.SpringGraphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebasket.SpringGraphql.repository.Book;
import com.codebasket.SpringGraphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Service
public class BookDataFetcher implements DataFetcher<Book> {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
		String id = dataFetchingEnvironment.getArgument("id");
		return bookRepository.findById(id).orElse(null);
	}
}
