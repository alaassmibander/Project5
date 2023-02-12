package com.example.project5.Controller;

import com.example.project5.DTO.BookDTO;
import com.example.project5.Model.Book;
import com.example.project5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBook() {
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book was added.");
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity updateBook(@RequestBody @Valid Book book, @PathVariable Integer bookId) {
        bookService.updateBook(bookId, book);
        return ResponseEntity.status(200).body("Book updates");
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.status(200).body("Book deleted");
    }

    @PutMapping("/assign/{bookId}/store/{storeId}")
    public ResponseEntity assignStoreToBook(@PathVariable Integer bookId, @PathVariable Integer storeId) {
        bookService.assignBookToStore(bookId, storeId);
        return ResponseEntity.status(200).body("Store with id: " + storeId + ", was assigned to book: " + bookId);
    }

    @GetMapping("/get/{bookId}/count")
    public ResponseEntity getBookCount(@PathVariable Integer bookId) {
        return ResponseEntity.status(200).body(bookService.booksAvailableForBook(bookId));
    }

    @GetMapping("/get/name")
    public ResponseEntity getBookByName(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(200).body(bookService.getBookByName(bookDTO.getName()));
    }

    @GetMapping("/get/genre")
    public ResponseEntity getBooksByGenre(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(200).body(bookService.getBooksByGenre(bookDTO.getGenre()));
    }
}
