package com.graphql.learn.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.learn.entity.Book;
import com.graphql.learn.pojo.BookInput;
import com.graphql.learn.service.BookService;

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
		Book b = Book.builder()
				.title(book.getTitle())
				.desc(book.getDesc())
				.price(book.getPrice())
				.author(book.getAuthor())
				.pages(book.getPages())
				.build();
		return this.bookService.create(b);
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
}