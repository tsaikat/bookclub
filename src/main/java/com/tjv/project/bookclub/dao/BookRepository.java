package com.tjv.project.bookclub.dao;

import com.tjv.project.bookclub.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>{


    @Query(value = "SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(CONCAT('%',:author,'%'))")
    Collection<Book> findByAuthor(@Param("author") String author);
}
