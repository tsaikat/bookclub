package com.tjv.project.bookclub.dao;


import com.tjv.project.bookclub.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
}
