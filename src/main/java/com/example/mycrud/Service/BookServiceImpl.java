package com.example.mycrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.Model.Book;
import com.example.mycrud.Model.Story;
import com.example.mycrud.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	

    @Autowired
    private BookRepository bookRepository;

	@Override
    public Book saveBook(Book book) {
        Story story = book.getStory();
        story.setBook(book);
        book = bookRepository.save(book);
        return book;
    }

	@Override
    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
	


}
