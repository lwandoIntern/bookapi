package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/boookapi")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> list = bookService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        long id = bookService.save(book);
        return ResponseEntity.ok().body("Book created with id: "+id);
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id){
         Book book = bookService.get(id);
         return  ResponseEntity.ok().body(book);
    }

    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book){
        bookService.update(id,book);
        return ResponseEntity.ok().body("Book updated!");
    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        bookService.delete(id);
        return ResponseEntity.ok().body("Book deleted.");
    }
}
