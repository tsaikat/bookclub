package com.tjv.project.bookclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public Book(Long bookId, String bookTitle, String author, String genre) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
    }

    public Book() {

    }

    public Book(Long id) {
        this.bookId = id;
    }

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

    public void setBorrowingHistory(Borrowing borrowingHistory) {

        this.borrowingHistory.add(borrowingHistory);
    }
}