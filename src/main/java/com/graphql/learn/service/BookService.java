package com.graphql.learn.service;

import java.util.List;

import com.graphql.learn.entity.Book;
import com.graphql.learn.pojo.BookInput;

public interface BookService
{
	// create
	Book create(BookInput book);

	// get all
	List<Book> getAll();

	// get single book
	Book get(int bookId);

	Book update(int bookId, BookInput book);

	String remove(int bookId);
}
