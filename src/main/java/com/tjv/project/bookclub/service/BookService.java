package com.tjv.project.bookclub.service;

import com.tjv.project.bookclub.dao.BookRepository;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.exception.IllegalDataException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService extends CrudService<Book, Long>{

    public BookService(BookRepository repository) {
        super(repository);
    }

    @Override
    protected Long id(Book e) {
        return e.getBookId();
    }

    @Override
    public Book create (Book e) {
        if (e.getBookTitle() == null || e.getBookTitle().isEmpty()
                || e.getAuthor() == null || e.getAuthor().isEmpty()
                || e.getGenre() == null || e.getGenre().isEmpty()) {
            throw new IllegalDataException();
        }
        return repository.save(e);
    }

    @Override
    public Book update (Long id, Book e) {
        Book bookToUpdate;
        if (!Objects.equals(e.getBookId(), id)) throw new IllegalDataException();
        try {
            bookToUpdate = repository.findById(id).orElseThrow();
        } catch (IllegalArgumentException | NoSuchElementException ex) {
            throw new IllegalDataException();
        }

        bookToUpdate.setBookTitle(e.getBookTitle());
        bookToUpdate.setAuthor(e.getAuthor());
        bookToUpdate.setGenre(e.getGenre());
        return repository.save(bookToUpdate);
    }

    public Collection<Book> findByAuthor (String author) {
        return ((BookRepository) repository).findByAuthor(author);
    }

}
