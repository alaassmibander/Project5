package com.example.project5.Service;

import com.example.project5.Exception.APIException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final StoreService storeService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookBy(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null)
            throw new APIException("Book not found");
        return book;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Integer bookId, Book book) {
        Book storedBook = getBookBy(bookId);

        storedBook.setName(book.getName());
        bookRepository.save(storedBook);
    }

    public void deleteBook(Integer bookId) {
        getBookBy(bookId);
        bookRepository.deleteById(bookId);
    }

    public void assignBookToStore(Integer bookId, Integer storeId) {
        Book book = getBookBy(bookId);
        Store store = storeService.getStoreBy(storeId);

        book.setStore(store);
        bookRepository.save(book);
    }

    public Integer booksAvailableForBook(Integer bookId) {
        Book book = getBookBy(bookId);
        return book.getBookCount();
    }

    public Book getBookByName(String name) {
        Book book = bookRepository.findBookByNameEquals(name);

        if (book == null)
            throw new APIException("Book not found");
        return book;
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findAllByGenreEquals(genre);
    }
}