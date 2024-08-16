package org.example.bibliotheque.controller;

import org.example.bibliotheque.model.Livre;
import org.example.bibliotheque.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Livre>> getAllBook() {
        return ResponseEntity.ok(bookService.findAllBook());
    }

    @PostMapping("/")
    public ResponseEntity<Livre> addNewBook(@RequestBody Livre livre) {
        return ResponseEntity.ok(bookService.createBook(livre));
    }

    @DeleteMapping("/")
    public ResponseEntity<Boolean> deleteBookById(@PathVariable long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}

