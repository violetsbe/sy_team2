package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Book;

import com.persistence.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {

	
	@Resource(name="bookDAO")
	private BookDAO bookDAO;
	
	@Override
	public List<Book> list() {
		List<Book> result = this.bookDAO.list();
		return result;
	}

	@Override
	public int bookInsert(Book b) {
		int result = this.bookDAO.bookInsert(b);
		return result;
	}

	@Override
	public int bookDelete(Book b) {
		int result = this.bookDAO.bookDelete(b);
		return result;
	}





}
