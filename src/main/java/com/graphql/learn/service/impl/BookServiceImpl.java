package com.graphql.learn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.graphql.learn.entity.Book;
import com.graphql.learn.exception.BookNotFoundException;
import com.graphql.learn.pojo.BookInput;
import com.graphql.learn.repository.BookRepo;
import com.graphql.learn.service.BookService;

/**
 * Implementation class for processing data
 * @author Amlan
 *
 */
@Service
public class BookServiceImpl implements BookService
{
	private final BookRepo bookRepo;

	public BookServiceImpl(BookRepo bookRepo)
	{
		this.bookRepo = bookRepo;
	}

	@Override
	public Book create(BookInput book)
	{
		Book b = Book.builder()
				.title(book.getTitle())
				.desc(book.getDesc())
				.price(book.getPrice())
				.author(book.getAuthor())
				.pages(book.getPages())
				.build();
		return this.bookRepo.save(b);
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
				.orElseThrow(() -> new BookNotFoundException("Book you are looking for not found on server !!"));
	}

	@Override
	public Book update(int bookId, BookInput book)
	{
		Optional<Book> optExistingBook = this.bookRepo.findById(bookId);

		if(optExistingBook.isPresent())
		{
			Book existingBook = optExistingBook.get();
			existingBook.setTitle(book.getTitle());
			existingBook.setDesc(book.getDesc());
			existingBook.setPrice(book.getPrice());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPages(book.getPages());

			Book updatedBook = this.bookRepo.save(existingBook);
			return updatedBook;
		}
		else
		{
			throw new BookNotFoundException("Book you are trying to update is not found on server !!");
		}
	}

	@Override
	public String remove(int bookId)
	{
		Optional<Book> optExistingBook = this.bookRepo.findById(bookId);

		if(optExistingBook.isPresent())
		{
			Book bookToBeDeleted = optExistingBook.get();

			this.bookRepo.delete(bookToBeDeleted);
			return "book with id: " + bookId + " has been successfully deleted";
		}

		else
		{
			throw new BookNotFoundException("Book you are trying to delete is not found on server !!");
		}
	}
}
