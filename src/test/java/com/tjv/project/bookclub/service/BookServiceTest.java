package com.tjv.project.bookclub.service;

import com.tjv.project.bookclub.dao.BookRepository;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.exception.IllegalDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService service;
    @MockBean
    private BookRepository repository;

    Long idExist = 1L;
    Long idNotExist = 2L;
    Book inputBookValid = new Book(idExist,"Book Title", "Author", "Genre");
    Book inputBookInvalid = new Book(idNotExist,"Book Title", "Author", "Genre");
    Book bookInDB = new Book(idExist, "Old Title", "Old Author", "Old Genre");


    @BeforeEach
    void setUp() {
        // mock for isolating the method
        Mockito.when(repository.findById(inputBookValid.getBookId())).thenReturn(Optional.of(bookInDB));
        Mockito.when(repository.save(bookInDB)).thenReturn(inputBookValid);
    }

    @Test
    void testUpdateWithValidInput() {
        // get result
        Book result = service.update(idExist, inputBookValid);

        // check results
        assertEquals(inputBookValid.getBookTitle(), result.getBookTitle());
        assertEquals(inputBookValid.getAuthor(), result.getAuthor());
        assertEquals(inputBookValid.getGenre(), result.getGenre());

        Mockito.verify(repository, Mockito.atLeast(1)).findById(idExist);
        Mockito.verify(repository, Mockito.atLeast(1)).save(bookInDB);
    }

    @Test
    void testUpdateWithInvalidInput() {
        assertThrows(IllegalDataException.class, () -> service.update(idNotExist, inputBookInvalid));
        assertThrows(IllegalDataException.class, () -> service.update(idNotExist, inputBookValid));
        assertThrows(IllegalDataException.class, () -> service.update(idExist, inputBookInvalid));

        Mockito.verify(repository, Mockito.never()).save(bookInDB);
    }
}