package com.graphql.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.learn.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>
{
}
