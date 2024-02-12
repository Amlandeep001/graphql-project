package com.graphql.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.learn.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>
{
}
