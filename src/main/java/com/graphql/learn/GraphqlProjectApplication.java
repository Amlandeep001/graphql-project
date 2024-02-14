package com.graphql.learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.graphql.learn.pojo.BookInput;
import com.graphql.learn.service.BookService;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner
{
	private final BookService bookService;

	public GraphqlProjectApplication(BookService bookService)
	{
		this.bookService = bookService;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		BookInput b1 = BookInput.builder()
				.title("Complete Reference")
				.desc("For learning java")
				.pages(2000)
				.price(5000)
				.author("XYZ")
				.build();

		BookInput b2 = BookInput.builder()
				.title("Think Java")
				.desc("For learning java")
				.pages(3000)
				.price(5000)
				.author("ABC")
				.build();

		BookInput b3 = BookInput.builder()
				.title("Head first to java")
				.desc("For starting java concepts")
				.pages(1000)
				.price(2000)
				.author("PQR")
				.build();

		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);
	}
}
