package com.graphql.learn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphql.learn.entity.Book;
import com.graphql.learn.repository.BookRepo;
import com.graphql.learn.service.BookService;

@Service
public class BookServiceImpl implements BookService
{
	private final BookRepo bookRepo;

	public BookServiceImpl(BookRepo bookRepo)
	{
		this.bookRepo = bookRepo;
	}

	@Override
	public Book create(Book book)
	{
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> getAll()
	{
		return this.bookRepo.findAll();
	}

	@Override
	public Book get(int bookId)
	{
		return this.bookRepo.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
	}
}
