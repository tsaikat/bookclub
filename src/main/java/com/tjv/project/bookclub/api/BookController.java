package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController extends CrudRestController<Book, Long>{

    public BookController(BookService service) {
        super(service);
    }
}
