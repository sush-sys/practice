package com.apibootrestapibook.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apibootrestapibook.entity.Book;
import com.apibootrestapibook.service.BookService;

@RestController
public class BookControllers {

	// @RequestMapping(value="/book", method = RequestMethod.GET)
	// @ResponseBody

	@Autowired
	private BookService bookservice;
	
/*
	@GetMapping("/books")
	public ArrayList<Book> getBooks() {

		return bookservice.getAllBook();
	}

	*/
	@GetMapping("/books")
	public ResponseEntity<ArrayList<Book>> getBooks() {
		
		ArrayList<Book> lis=bookservice.getAllBook();
		
		if(lis.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(lis));
	}
	
	/*
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookservice.getBookById(id);
	}
	*/
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		Book b=bookservice.getBookById(id);
		if(b==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}
	
	/*
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b=bookservice.addBook(book);
		return b;
	}
	*/
	
	@PostMapping("/books")
	public ResponseEntity<Book>addBook(@RequestBody Book book)
	{
		Book b=null;
		try{
		b=bookservice.addBook(book);
//		return ResponseEntity.of(Optional.of(b));
		return ResponseEntity.status(HttpStatus.CREATED).body(b);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	/*
	@DeleteMapping("/books/{id}")
	public Book deleteBook(@PathVariable("id") int id)
	{
		Book b=bookservice.deleteBook(id);
		return b;
	}
	*/
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id)
	{
		Book b=null;
//		try {
//		 b=bookservice.deleteBook(id);
//		 if(b!=null)
//		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		 else
//			 ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
		b=bookservice.deleteBook(id);
		if(b!=null)
//			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			return ResponseEntity.of(Optional.of(b));
		else
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		
	}
	
	// update the data
	
	
	
	/*
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		Book b=bookservice.updateBooks(book,id);
		return b;
	}
	*/
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		Book b=null;
		try
		{
			b=bookservice.updateBooks(book, id);
			return ResponseEntity.of(Optional.of(b));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
				
	}
	
	
	
	
	
	
	
	
	

}
