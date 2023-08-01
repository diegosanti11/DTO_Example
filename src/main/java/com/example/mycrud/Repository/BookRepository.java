package com.example.mycrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	 public Book findByBookId(int bookId);
}
