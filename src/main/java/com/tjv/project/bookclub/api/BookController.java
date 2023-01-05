package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.api.dto.BookDto;
import com.tjv.project.bookclub.api.dto.converter.BookDtoToEntityConverter;
import com.tjv.project.bookclub.api.dto.converter.BookToDtoConverter;
import com.tjv.project.bookclub.domain.Book;
import com.tjv.project.bookclub.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/books")
public class BookController extends CrudRestController<Book, BookDto, Long>{

    public BookController(BookService service, BookToDtoConverter toDtoConverter, BookDtoToEntityConverter toEntityConverter ) {
        super(service, toDtoConverter, toEntityConverter);
    }

    @GetMapping("/author")
    @ResponseBody
    public Iterable<BookDto> findByAuthor (@RequestParam(value = "name") String author) {
        if (author.isEmpty()) return Collections.emptyList();
        return (((BookService)service)
                    .findByAuthor(author))
                    .stream()
                    .map(toDtoConverter)
                    .toList();
    }
}
