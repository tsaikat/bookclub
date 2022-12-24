package com.tjv.project.bookclub.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column
    private String bookTitle;

    @Column
    private String author;

    @Column
    private String genre;

    @ManyToMany
    private Collection<Borrowing> borrowingHistory;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Collection<Borrowing> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(Collection<Borrowing> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
}