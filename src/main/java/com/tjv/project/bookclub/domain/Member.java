package com.tjv.project.bookclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @Column
    private LocalDateTime joinDate;

    @Column
    private Long balance;

    @OneToMany(mappedBy = "borrower")
    private Collection<Borrowing> borrowings;

    public Member(Long id, String firstName, String lastName, Long balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Member() {

    }

    public Member(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Collection<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Collection<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public void setBorrowings(Borrowing borrowing) {
        this.borrowings.add(borrowing);
    }
}
