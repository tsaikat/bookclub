package com.tjv.project.bookclub.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Collection;

public class BorrowingDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long borrowingId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private  LocalDateTime borrowDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime returnDate;
    private Long Cost;

    private Collection<Long> borrowedBooks;
    private Long borrower;
    private String borrowerName;

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public BorrowingDto(Long borrowingId, LocalDateTime borrowDate, LocalDateTime returnDate, Long cost, Collection<Long> borrowedBooks, Long borrower, String borrowerName) {
        this.borrowingId = borrowingId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        Cost = cost;
        this.borrowedBooks = borrowedBooks;
        this.borrower = borrower;
        this.borrowerName = borrowerName;
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
        return Cost;
    }

    public void setCost(Long cost) {
        Cost = cost;
    }

    public Collection<Long> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Long> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Long getBorrower() {
        return borrower;
    }

    public void setBorrower(Long borrower) {
        this.borrower = borrower;
    }
}
