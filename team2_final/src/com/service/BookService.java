package com.service;

import java.util.List;

import com.domain.Book;


public interface BookService {

	
	
	//교재 출력
	public List<Book> list();
	
	//교재 추가
	public int bookInsert(Book b);
	
	//교재 삭제
	public int bookDelete(Book b);
		

	
}

	

