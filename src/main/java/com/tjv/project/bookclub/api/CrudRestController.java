package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.service.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public abstract class CrudRestController <T, ID> {

    protected CrudService<T, ID> service;

    public CrudRestController(CrudService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public T create (@RequestBody T e) {
        return service.create(e);
    }

    @GetMapping
    @ResponseBody
    public Iterable<T> readAll () {
        return service.readAll();
    }

//    @PutMapping ("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update (@PathVariable ID id, @RequestBody T e) {
//        service.update(id, e);
//    }
}