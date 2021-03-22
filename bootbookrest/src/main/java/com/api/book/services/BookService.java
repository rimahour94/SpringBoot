package com.api.book.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookService {
   
	private static List<Book>list =new ArrayList<>();
	
	static {
		list.add(new Book(12,"Java Complete Reference","Abc"));
		list.add(new Book(24,"Python Complete Edition","Xyz"));
		list.add(new Book(36,"C++ book","Jkl"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
	     return book;
	}
	
	public Book addBook(Book book) {
		
		list.add(book);
		return book;
	}
	
	public void deleteBook(int bid) {
		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	}
}
