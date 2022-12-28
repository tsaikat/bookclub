package com.tjv.project.bookclub.api.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class MemberDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String firstName;
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime joinDate;
    private Long balance;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<Long> borrowings;

    public MemberDto(Long id, String firstName, String lastName, LocalDateTime joinDate,
                     Long balance, Collection<Long> borrowings) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.balance = balance;
        this.borrowings = borrowings;
    }

    public MemberDto() {
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

    public Collection<Long> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Collection<Long> borrowings) {
        this.borrowings = borrowings;
    }
}
