package com.graphql.learn.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.learn.entity.Book;
import com.graphql.learn.pojo.BookInput;
import com.graphql.learn.service.BookService;

/**
 * Controller for maintaining book related GraphQL operations
 * @author Amlan
 *
 */

@Controller
public class BookController
{
	private final BookService bookService;

	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	// create
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book)
	{
		return this.bookService.create(book);
	}

	// get all
	@QueryMapping("allBooks")
	public List<Book> getAll()
	{
		return this.bookService.getAll();
	}

	// get single book
	@QueryMapping("getBook")
	public Book get(@Argument int bookId)
	{
		return this.bookService.get(bookId);
	}

	// update
	@MutationMapping("updateBook")
	public Book update(@Argument int bookId, @Argument BookInput book)
	{
		return this.bookService.update(bookId, book);
	}

	// delete
	@MutationMapping("removeBook")
	public String remove(@Argument int bookId, @Argument BookInput book)
	{
		return this.bookService.remove(bookId);
	}
}