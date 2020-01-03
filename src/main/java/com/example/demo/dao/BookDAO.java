package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;

public interface BookDAO
{
    long save(Book book);

    Book get(long id);

    List<Book> getAll();

    void update(long id, Book book);

    void delete(long id);
}
