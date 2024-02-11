package com.graphql.learn.pojo;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class BookInput
{
	String title;
	String desc;
	String author;
	double price;
	int pages;
}
