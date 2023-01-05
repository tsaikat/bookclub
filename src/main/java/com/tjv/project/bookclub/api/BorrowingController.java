package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.api.dto.BorrowingDto;
import com.tjv.project.bookclub.api.dto.converter.BorrowingDtoToEntityConverter;
import com.tjv.project.bookclub.api.dto.converter.BorrowingToDtoConverter;
import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.service.BorrowingService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController extends CrudRestController<Borrowing, BorrowingDto, Long>{

    public BorrowingController(BorrowingService service, BorrowingToDtoConverter toDtoConverter,
                               BorrowingDtoToEntityConverter toEntityConverter) {
        super(service, toDtoConverter, toEntityConverter);
    }

//    @Override
//    @DeleteMapping("/{id}")
//    @Query("DELETE FROM Borrowing b JOIN b.books book WHERE b.id = :borrowingId")
//    public void delete((@Param("borrowingId")) @PathVariableLong id);
}
