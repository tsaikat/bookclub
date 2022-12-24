package com.tjv.project.bookclub.service;

import com.tjv.project.bookclub.dao.BookRepository;
import com.tjv.project.bookclub.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends CrudService<Book, Long>{

    public BookService(BookRepository repository) {
        super(repository);
    }

    @Override
    protected Long id(Book e) {
        return e.getBookId();
    }
}
