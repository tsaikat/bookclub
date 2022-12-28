package com.tjv.project.bookclub.api.dto.converter;

import com.tjv.project.bookclub.api.dto.BorrowingDto;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.domain.Member;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BorrowingDtoToEntityConverter implements Function<BorrowingDto, Borrowing> {
    @Override
    public Borrowing apply(BorrowingDto borrowingDto) {
        if (borrowingDto.getBorrowedBooks() == null || borrowingDto.getBorrower() == null || borrowingDto.getCost() == null) {
            return new Borrowing();
        }

        return  new Borrowing(borrowingDto.getBorrowedBooks().stream().map(Book::new).toList(), new Member(borrowingDto.getBorrower()), borrowingDto.getCost() );
    }
}
