package com.tjv.project.bookclub.service;


import com.tjv.project.bookclub.dao.BorrowingRepository;
import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.exception.IllegalDataException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class BorrowingService extends CrudService<Borrowing, Long>{

    public BorrowingService(BorrowingRepository repository, BookService bookService, MemberService memberService) {
        super(repository);
        this.bookService = bookService;
        this.memberService = memberService;
    }
    private final BookService bookService;
    private final MemberService memberService;

    @Override
    protected Long id(Borrowing e) {
        return e.getBorrowingId();
    }

    @Override
    @Transactional
    public Borrowing create (Borrowing e) {
        if (e.getBorrowedBooks() == null || e.getBorrowedBooks().isEmpty()
            || e.getBorrower() == null || e.getCost() == null) {
            throw new IllegalDataException();
        }

        try  {
            e.setBorrowedBooks(e.getBorrowedBooks().stream().map(book -> bookService.readById(book.getBookId())).toList());
            e.setBorrower(memberService.readById(e.getBorrower().getId()));

            if (e.getBorrower().getBalance() < e.getCost()) {
                throw new IllegalDataException();
            } else {
                e.getBorrower().setBalance(e.getBorrower().getBalance() - e.getCost());
                memberService.update(e.getBorrower().getId(), e.getBorrower());
            }
        } catch (RuntimeException ex) {
            throw new IllegalDataException();
        }

        e.setBorrowDate(LocalDateTime.now());
        e.getBorrowedBooks().forEach(book -> book.setBorrowingHistory(e));
        e.getBorrower().setBorrowings(e);
        return repository.save(e);
    }


    @Override
    @Transactional
    public Borrowing update (Long id, Borrowing e) {
        // can only update return date

        var borrowingToUpdate = repository.findById(id).orElseThrow();
        if (borrowingToUpdate.getReturnDate() == null) {
            borrowingToUpdate.setReturnDate(LocalDateTime.now());
            return repository.save(borrowingToUpdate);
        }
        return borrowingToUpdate;
    }
}
