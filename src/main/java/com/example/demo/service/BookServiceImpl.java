package com.example.demo.service;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public long save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    @Transactional
    public Book get(long id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    @Transactional
    public void update(long id, Book book) {
        bookDAO.update(id,book);
    }

    @Override
    @Transactional
    public void delete(long id) {
        bookDAO.delete(id);
    }
}
