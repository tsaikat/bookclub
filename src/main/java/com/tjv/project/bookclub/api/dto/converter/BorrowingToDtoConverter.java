package com.tjv.project.bookclub.api.dto.converter;

import com.tjv.project.bookclub.api.dto.BorrowingDto;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.domain.Borrowing;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class BorrowingToDtoConverter implements Function<Borrowing, BorrowingDto> {

    @Override
    public BorrowingDto apply(Borrowing borrowing) {
        if ( borrowing.getBorrowedBooks() == null || borrowing.getBorrower() == null ) {
            return new BorrowingDto(borrowing.getBorrowingId(), borrowing.getBorrowDate(), borrowing.getReturnDate(),
                    borrowing.getCost(), null, null);
        }

        return new BorrowingDto(borrowing.getBorrowingId(), borrowing.getBorrowDate(), borrowing.getReturnDate(),
                borrowing.getCost(), borrowing.getBorrowedBooks().stream().map(Book::getBookId).toList(),
                borrowing.getBorrower().getId());
    }
}
