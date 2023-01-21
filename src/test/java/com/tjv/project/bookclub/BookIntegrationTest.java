package com.tjv.project.bookclub;

import com.tjv.project.bookclub.api.BookController;
import com.tjv.project.bookclub.api.dto.BookDto;
import com.tjv.project.bookclub.domain.Book;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

@SpringBootTest
@AutoConfigureTestDatabase
public class BookIntegrationTest {
    @Autowired
    private BookController bookController;

    @Test
    @Transactional
    void testBookAddDeleteIntegration() {
        //create a new book
        var newBook = bookController.create(new BookDto( 1L, "BookTitle", "Author", "Genre" ));

        //get all book
        var res = bookController.readAll();

        // check the book we created is in the result of all book
        Assertions.assertTrue(StreamSupport.stream(res.spliterator(), false)
                .anyMatch(book -> book.getBookId().equals(newBook.getBookId())
                        && book.getBookTitle().equals(newBook.getBookTitle())
                        && book.getAuthor().equals(newBook.getAuthor())
                        && book.getGenre().equals(newBook.getGenre())));

        //Delete the new book from DB
        bookController.delete(newBook.getBookId());

        res = bookController.readAll();
        // Check if it's deleted
        Assertions.assertFalse(StreamSupport.stream(res.spliterator(), false)
                .anyMatch(book -> book.getBookId().equals(newBook.getBookId())
                        && book.getBookTitle().equals(newBook.getBookTitle())
                        && book.getAuthor().equals(newBook.getAuthor())
                        && book.getGenre().equals(newBook.getGenre())));
    }


    @Test
    @Transactional
    void testBookReadUpdateIntegration() {
        // Create new book
        var newBook = bookController.create(new BookDto( null, "BookTitle", "Author", "Genre" ));
        // create a BookDTO to update to
        BookDto updatedBook = new BookDto(newBook.getBookId(), "updatedBookTitle", "updatedAuthor", "updatedGenre");


        bookController.update(updatedBook.getBookId(), updatedBook);
        var res = bookController.readById(updatedBook.getBookId());


        Assertions.assertTrue(res.getBookId().equals(updatedBook.getBookId())
                && res.getBookTitle().equals(updatedBook.getBookTitle())
                && res.getAuthor().equals(updatedBook.getAuthor())
                && res.getGenre().equals(updatedBook.getGenre()));

        bookController.delete(newBook.getBookId());
    }


    @Test
    void testBookReadUpdateIntegrationInvalidInput() {
        //create a book
        var newBook = bookController.create(new BookDto( 1L, "BookTitle", "Author", "Genre", null ));
        // remove it
        bookController.delete(newBook.getBookId());

        //try updating it
        var updatedBook = new BookDto(newBook.getBookId(), "updatedBookTitle", "updatedAuthor", "updatedGenre", null);
        Assertions.assertThrows(ResponseStatusException.class, ()-> bookController.update(updatedBook.getBookId(), updatedBook));
    }

}
