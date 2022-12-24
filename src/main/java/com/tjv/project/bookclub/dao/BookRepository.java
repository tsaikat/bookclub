package com.tjv.project.bookclub.dao;

import com.tjv.project.bookclub.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
}
