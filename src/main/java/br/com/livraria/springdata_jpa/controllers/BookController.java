package br.com.livraria.springdata_jpa.controllers;

import br.com.livraria.springdata_jpa.dtos.BookRecordDto;
import br.com.livraria.springdata_jpa.models.BookModel;
import br.com.livraria.springdata_jpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // anotações das requisições HTTP
@RequestMapping("/bookstore/books") // endpoint da requisição
public class BookController {

    @Autowired // instancia do bookservice
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // acessa todos os books
    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @PostMapping // chama o metodo save de bookmodel para salvar pelo corpo da requisição com requestbody e metodo post
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));

    }
    // apaga o book pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }

}
