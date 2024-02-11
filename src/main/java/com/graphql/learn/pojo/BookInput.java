package com.graphql.learn.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookInput
{
	String title;
	String desc;
	String author;
	double price;
	int pages;
}
