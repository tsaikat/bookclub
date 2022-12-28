package com.tjv.project.bookclub.service;


import com.tjv.project.bookclub.exception.IllegalDataException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class CrudService <T, ID> {
    protected CrudRepository<T, ID> repository;
    protected abstract ID id(T e);
    public CrudService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }


    public T create (T e) {
        return repository.save(e);
    }

    public Iterable<T> readAll () {
        // logic goes here
        return repository.findAll();
    }

    public T readById (ID id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new IllegalDataException();
        }
    }
    public T update (ID id, T e) {
        return repository.save(e);
    }
     public void deleteById (ID id) {
        repository.deleteById(id);
     }
}
