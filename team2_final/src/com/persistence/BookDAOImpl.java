package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Book;
import com.mapper.BookViewDeleteMapper;

@Repository("bookDAO")

public class BookDAOImpl implements BookDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public List<Book> list() {
		String sql= "SELECT book_id, book_name, isbn,\r\n" + 
				"   (SELECT COUNT(*)\r\n" + 
				"      FROM open_subject os\r\n" + 
				"      WHERE B.book_id = os.book_id) count_\r\n" + 
				"    FROM book b \r\n";
		
		List<Book> result = this.jdbcTemplateObject.query(sql, new BookViewDeleteMapper());
		return result;
	}

	@Override
	public int bookInsert(Book b) {
		String sql="INSERT INTO book (book_id, book_name, isbn)\r\n" + 
				"VALUES ((SELECT CONCAT('B', LPAD(IFNULL(SUBSTR(MAX(book_id), 2), 0 )+1, 3, 0)) AS newid FROM book b), ?, ?)"; 
				
		int result = this.jdbcTemplateObject.update(sql, b.getBook_name(),b.getIsbn());
		return result;
	}

	@Override
	public int bookDelete(Book b) {
		String sql="DELETE FROM book\r\n" + 
				"WHERE book_id = ?"; 
		int result = this.jdbcTemplateObject.update(sql,b.getBook_id());
		return result;
	}

	

	
	

}
