package com.graphql.learn.service;

import java.util.List;

import com.graphql.learn.entity.Book;

public interface BookService
{
	// create
	Book create(Book book);

	// get all
	List<Book> getAll();

	// get single book
	Book get(int bookId);
}
