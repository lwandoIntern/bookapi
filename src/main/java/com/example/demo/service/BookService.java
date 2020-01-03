package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    long save(Book book);

    Book get(long id);

    List<Book> getAll();

    void update(long id, Book book);

    void delete(long id);
}
