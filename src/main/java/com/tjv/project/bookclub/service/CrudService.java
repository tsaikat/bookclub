package com.tjv.project.bookclub.service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public abstract class CrudService <T, ID> {
    protected CrudRepository<T, ID> repository;

    public CrudService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create (T e) {
        // logic goes here
        return repository.save(e);
    }

    public Iterable<T> readAll () {
        // logic goes here
        return repository.findAll();
    }

//    public void update (ID id, T e) {
//        Optional<T> temp = repository.findById(id);
//        if (temp.isPresent()) {
//            temp.get() = e.
//            repository.save(temp.get());
//        }
//    }
    protected abstract ID id(T e);

}
