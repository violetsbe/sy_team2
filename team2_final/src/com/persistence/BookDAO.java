package com.persistence;

import java.util.List;

import com.domain.Book;

public interface BookDAO {

	//교재출력
	public List<Book> list();
	
	
	//교재등록
	public int bookInsert(Book b);
	
	
	//교재삭제
	public int bookDelete(Book b);
	
	
}
