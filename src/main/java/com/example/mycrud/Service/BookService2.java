package com.example.mycrud.Service;

import com.example.mycrud.Model.Book2;

public interface BookService2 {
    public Book2 saveBook(Book2 book);
    public Book2 findByBookId(int bookId);
}