package com.example.project5.Repository;

import com.example.project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByNameEquals(String name);

    List<Book> findAllByGenreEquals(String genre);
}
