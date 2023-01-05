package com.tjv.project.bookclub.dao;


import com.tjv.project.bookclub.domain.Borrowing;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
}
