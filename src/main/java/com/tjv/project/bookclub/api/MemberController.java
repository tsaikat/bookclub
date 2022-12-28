package com.tjv.project.bookclub.api;

import com.tjv.project.bookclub.api.dto.MemberDto;
import com.tjv.project.bookclub.api.dto.converter.MemberDtoToEntityConverter;
import com.tjv.project.bookclub.api.dto.converter.MemberToDtoConverter;
import com.tjv.project.bookclub.domain.Member;
import com.tjv.project.bookclub.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController extends CrudRestController<Member, MemberDto, Long>{

    public MemberController(MemberService service, MemberToDtoConverter toDtoConverter,
                            MemberDtoToEntityConverter toEntityConverter) {
        super(service, toDtoConverter, toEntityConverter);
    }
}
