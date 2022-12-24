package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.domain.Member;
import com.tjv.project.bookclub.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController extends CrudRestController<Member, Long>{

    public MemberController(MemberService service) {
        super(service);
    }
}
