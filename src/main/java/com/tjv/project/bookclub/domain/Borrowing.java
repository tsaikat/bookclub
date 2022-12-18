package com.tjv.project.bookclub.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowingId;
    @Column
    private Date borrowDate;
    @Column
    private Date returnDate;
    @Column
    private long cost;
    @ManyToMany
    private Collection<Book> borrowedBooks;
    @ManyToOne
    private Member borrower;
}
