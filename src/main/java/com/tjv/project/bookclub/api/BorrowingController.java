package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.api.dto.BorrowingDto;
import com.tjv.project.bookclub.api.dto.converter.BorrowingDtoToEntityConverter;
import com.tjv.project.bookclub.api.dto.converter.BorrowingToDtoConverter;
import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.service.BorrowingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController extends CrudRestController<Borrowing, BorrowingDto, Long>{

    public BorrowingController(BorrowingService service, BorrowingToDtoConverter toDtoConverter,
                               BorrowingDtoToEntityConverter toEntityConverter) {
        super(service, toDtoConverter, toEntityConverter);
    }
}
