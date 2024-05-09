package com.graphql.learn.data;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.graphql.learn.entity.Book;
import com.graphql.learn.repository.BookRepo;

@Component
public class SampleDataLoader implements CommandLineRunner
{
	private final BookRepo bookRepo;

	public SampleDataLoader(BookRepo bookRepo)
	{
		this.bookRepo = bookRepo;
	}

	@Override
	public void run(String... args) throws Exception
	{
		Book book1 = Book.builder()
				.title("Complete Reference")
				.desc("For learning java")
				.pages(2000)
				.price(5000)
				.author("XYZ")
				.build();

		Book book2 = Book.builder()
				.title("Think Java")
				.desc("For learning java")
				.pages(3000)
				.price(5000)
				.author("ABC")
				.build();

		Book book3 = Book.builder()
				.title("Head first to java")
				.desc("For starting java concepts")
				.pages(1000)
				.price(2000)
				.author("PQR")
				.build();

		List<Book> books = List.of(book1, book2, book3);
		bookRepo.saveAll(books);
	}
}
