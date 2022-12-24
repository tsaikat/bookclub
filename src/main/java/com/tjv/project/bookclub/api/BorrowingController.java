package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.service.BorrowingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController extends CrudRestController<Borrowing, Long>{

    public BorrowingController(BorrowingService service) {
        super(service);
    }
}
