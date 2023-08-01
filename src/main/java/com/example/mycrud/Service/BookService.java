package com.example.mycrud.Service;

import com.example.mycrud.Model.Book;

public interface BookService {
	
	public Book saveBook(Book book);
    public Book findByBookId(int bookId);

}
