package com.apibootrestapibook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apibootrestapibook.BookRepository;
import com.apibootrestapibook.entity.Book;


@Component
public class BookService {
	
	/*public static ArrayList<Book> list=new ArrayList();
	
	static
	{
		list.add(new Book(12,"java","xyz"));
		list.add(new Book(13,"C++","pqr"));
		list.add(new Book(14,"Python","abc"));

	}
	*/
	@Autowired
	private BookRepository bookRepository;
	
	// get all books
	public ArrayList<Book> getAllBook()
	{
		ArrayList<Book>list1=(ArrayList<Book>)bookRepository.findAll();
	
		return list1;
	}
	
	// get book by id
	public Book res=null;
	
	public Book getBookById(int id)
	{
		/*res=null;
		list.forEach(e->{
			//System.out.println(e);
			if(e.getId()==id)
			{
				
				res=e;
			}
		});
		
		//res= BookService.(id);
		
		return res;
		*/
		
		Book book=null;
		try {
			book=bookRepository.findById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
	
	// create data 
	
	public Book addBook(Book book)
	{
		
	
		//list.add(book);
		Book b=null;
		/*Book b1=bookRepository.findById(book.getId());
		if(b1.getId()==book.getId())
		{
			b=null;
			return b;
		}
		*/
		b=bookRepository.save(book);
		
		return b;
	}
	
	
	// delete book by id
	
	public Book deleteBook(int id)
	{
//		res=null;
//		list.forEach(e->
//		{
//			if(e.getId()==id)
//			{
//				res=e;
//			}
//		}
//		);
//		
//		list.remove(res);
//		
//		return res;
		//bookrepository.deleteById(id);
		//return res;
		
		
		Book book=null;
		try {
			book=bookRepository.findById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bookRepository.deleteById(id);
		return book;
	}
	
	// update book info
	
	public Book updateBooks(Book book,int id)
	{
        /*res=null;
		list.forEach(e->
		{
			if(e.getId()==id)
			{
				res=e;
			}
			
		}
		);
		if(res!=null)
		list.remove(res);
		if(res!=null)
		{
		list.add(book);
		res=book;
		}
		
		return res;
		
		
		*/
		
		 book.setId(id);
		res=bookRepository.save(book);
		return res;
	}
	
	

}
