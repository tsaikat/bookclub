package com.tjv.project.bookclub.domain;

import javax.persistence.*;
import java.sql.Date;
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
    private Date joinDate;
    @Column
    private Long balance;
    @OneToMany
    private Collection<Borrowing> borrowings;
}
