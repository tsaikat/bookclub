package com.tjv.project.bookclub.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


//@JsonIdentityInfo(
//        property = "borrowingId",
//        generator = ObjectIdGenerators.PropertyGenerator.class
//)
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long borrowingId;

    @Column
    private LocalDateTime borrowDate;

    @Column
    private LocalDateTime returnDate;

    @Column
    private Long cost;

    @ManyToMany(mappedBy = "borrowingHistory")
    private Collection<Book> borrowedBooks;

    @ManyToOne
    private Member borrower;

    public Borrowing(Long borrowingId, Long cost) {
        this.borrowingId = borrowingId;
        this.cost = cost;
    }

    public Borrowing() {

    }

    public Borrowing(List<Book> bookList, Member borrower, Long cost) {
        this.borrowedBooks = bookList;
        this.borrower = borrower;
        this.cost = cost;
    }

    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Collection<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }


    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }
}
