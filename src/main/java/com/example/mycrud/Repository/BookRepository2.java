package com.example.mycrud.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Book2;


@Repository
public interface BookRepository2 extends JpaRepository<Book2, String> {

    public Book2 findByBookId(int bookId);

}
