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
}