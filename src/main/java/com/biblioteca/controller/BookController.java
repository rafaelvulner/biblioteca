package com.biblioteca.controller;

import com.biblioteca.domain.dtos.BookDTO;
import com.biblioteca.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {


    private final BookService bookService;

    @PostMapping
    private ResponseEntity<BookDTO> getBook(@RequestBody BookDTO book) {
        BookDTO save = this.bookService.save(book);
        return ResponseEntity.status(201).body(save);
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.getBook(id));
    }

    @GetMapping
    private ResponseEntity<List<BookDTO>> getAllBook() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private ResponseEntity<String> removeBook(@PathVariable Long id) {
        this.bookService.removeBook(id);
        return ResponseEntity.ok("Seu Livro foi removido com sucesso!");
    }

}
