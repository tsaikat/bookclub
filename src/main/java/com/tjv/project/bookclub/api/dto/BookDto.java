package com.tjv.project.bookclub.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class BookDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long bookId;
    private String bookTitle;
    private String author;
    private String genre;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<Long> borrowingHistory;




    public Collection<Long> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(Collection<Long> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public BookDto() {
    }

    public BookDto(Long bookId, String bookTitle, String author, String genre, Collection<Long> borrowingHistory) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.borrowingHistory = borrowingHistory;
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



}
