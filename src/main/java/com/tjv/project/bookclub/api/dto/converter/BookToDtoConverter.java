package com.tjv.project.bookclub.api.dto.converter;


import com.tjv.project.bookclub.api.dto.BookDto;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.domain.Borrowing;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookToDtoConverter implements Function<Book, BookDto> {

    @Override
    public BookDto apply(Book book) {
        if (book.getBorrowingHistory() == null) {
            return new BookDto(book.getBookId(),book.getBookTitle(),book.getAuthor(), book.getGenre(), null);
        }

        return new BookDto(book.getBookId(),book.getBookTitle(),book.getAuthor(), book.getGenre(), book.getBorrowingHistory().stream().map(Borrowing::getBorrowingId).toList());
    }
}
