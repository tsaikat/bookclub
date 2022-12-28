package com.tjv.project.bookclub.api.dto.converter;

import com.tjv.project.bookclub.api.dto.BookDto;
import com.tjv.project.bookclub.domain.Book;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookDtoToEntityConverter implements Function<BookDto, Book> {

    @Override
    public Book apply(BookDto bookDto) {
        return new Book(bookDto.getBookId(),bookDto.getBookTitle(), bookDto.getAuthor(),bookDto.getGenre());
    }
}
