package com.tjv.project.bookclub.service;


import com.tjv.project.bookclub.dao.BorrowingRepository;
import com.tjv.project.bookclub.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowingService extends CrudService<Borrowing, Long>{

    public BorrowingService(BorrowingRepository repository) {
        super(repository);
    }

    @Override
    protected Long id(Borrowing e) {
        return e.getBorrowingId();
    }
}
