package com.graphql.learn.services;

import java.util.List;

import com.graphql.learn.entities.Book;

public interface BookService
{
	// create
	Book create(Book book);

	// get all
	List<Book> getAll();

	// get single book
	Book get(int bookId);
}
