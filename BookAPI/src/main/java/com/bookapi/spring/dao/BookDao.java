package com.bookapi.spring.dao;

import java.util.List;

import com.bookapi.spring.model.Book;

public interface BookDao 
{
	//save the record
	long save(Book book);
	
	//Get a single record
	Book get(long id);
	
	//Get all the Records
	List<Book> list();

	//update the recoed
	void update(long id,Book book);
	
	//Deleta a record
	void delete(long id);
}
