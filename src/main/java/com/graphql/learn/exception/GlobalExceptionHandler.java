package com.graphql.learn.exception;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.GraphQLError;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@GraphQlExceptionHandler
	public GraphQLError handleBookNotFpundException(Exception ex)
	{
		return GraphQLError.newError()
				.message(ex.getMessage())
				.build();
	}
}
