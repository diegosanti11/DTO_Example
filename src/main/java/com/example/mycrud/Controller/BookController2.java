package com.example.mycrud.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.Model.Book2;
import com.example.mycrud.Service.BookService2;



@RestController
@RequestMapping(value = "/book2")
public class BookController2 {

    @Autowired
    private BookService2 bookService;

    @RequestMapping(value = "/savebook2", method = RequestMethod.POST)
    @ResponseBody
    public Book2 saveBook(@RequestBody Book2 book) {
        Book2 bookResponse = bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Book2 getBookDetails(@PathVariable int bookId) {
        Book2 bookResponse = bookService.findByBookId(bookId);

        return bookResponse;
    }

}