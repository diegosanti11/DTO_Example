package com.example.mycrud.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.Model.Book2;
import com.example.mycrud.Model.Story2;
import com.example.mycrud.Repository.BookRepository2;



@Service
public class BookServiceImpl2 implements BookService2 {

    @Autowired
    private BookRepository2 bookRepository;


	@Override
	public Book2 saveBook(Book2 book) {
        List<Story2> storyList = new ArrayList<>();

        // create first story
        Story2 story1 = new Story2();
        story1.setStoryName("Arrays");

        // create second story
        Story2 story2 = new Story2();
        story2.setStoryName("Pointers");

        // create third story
        Story2 story3 = new Story2();
        story3.setStoryName("Loops");

        // add all story into storyList. Till here we have prepared data for OneToMany
        storyList.add(story1);
        storyList.add(story2);
        storyList.add(story3);

        // Prepare data for ManyToOne
        story1.setBook(book);
        story2.setBook(book);
        story3.setBook(book);

        book.setStoryList(storyList);
        book = bookRepository.save(book);

        return book;
	}

	@Override
	public Book2 findByBookId(int bookId) {
	     Book2 book = bookRepository.findByBookId(bookId);
	     return book;
	}
}
