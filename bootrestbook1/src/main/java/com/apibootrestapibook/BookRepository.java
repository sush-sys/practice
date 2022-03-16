package com.apibootrestapibook;

import org.springframework.data.repository.CrudRepository;

import com.apibootrestapibook.entity.Book;

public interface BookRepository  extends CrudRepository<Book, Integer> {
	public Book findById(int id);

}
