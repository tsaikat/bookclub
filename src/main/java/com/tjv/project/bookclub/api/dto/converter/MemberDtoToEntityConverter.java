package com.tjv.project.bookclub.api.dto.converter;

import com.tjv.project.bookclub.api.dto.MemberDto;
import com.tjv.project.bookclub.domain.Member;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MemberDtoToEntityConverter implements Function<MemberDto, Member> {
    @Override
    public Member apply(MemberDto memberDto) {
        return new Member(memberDto.getId(), memberDto.getFirstName(),memberDto.getLastName(),memberDto.getBalance());
    }
}
