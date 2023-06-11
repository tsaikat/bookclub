package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.exception.IllegalDataException;
import com.tjv.project.bookclub.service.CrudService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Function;
import java.util.stream.StreamSupport;

public abstract class CrudRestController <T, D, ID> {

    protected CrudService<T, ID> service;

    protected Function<T, D> toDtoConverter;
    protected Function<D, T> toEntityConverter;

    public CrudRestController(CrudService<T, ID> service, Function<T, D> toDtoConverter, Function<D, T> toEntityConverter) {
        this.service = service;
        this.toDtoConverter = toDtoConverter;
        this.toEntityConverter = toEntityConverter;
    }

    @PostMapping
    @ResponseBody
    public D create (@RequestBody D e) {
        try {
            return toDtoConverter.apply(service.create(toEntityConverter.apply(e)));
        } catch (IllegalDataException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @ResponseBody
    public Iterable<D> readAll () {
        return StreamSupport.stream(service.readAll().spliterator(), false).map(toDtoConverter).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public D readById(@PathVariable ID id) {
        try {
            return toDtoConverter.apply(service.readById(id));
        } catch (IllegalDataException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/{id}")
    @ResponseBody
    public D update (@PathVariable ID id, @RequestBody D e) {
        try {
            return toDtoConverter.apply(service.update(id, toEntityConverter.apply(e)));
        } catch ( RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id) {
        try {
            service.deleteById(id);
        } catch (IllegalArgumentException | DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}