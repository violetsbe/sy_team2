package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Book;


public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int count) throws SQLException {
		Book b = new Book();
		b.setBook_id(rs.getString("book_id"));
		b.setBook_name(rs.getString("book_name"));
		b.setIsbn(rs.getString("isbn"));
		b.setCount_(rs.getInt("count_"));
		return b;
	}

}
