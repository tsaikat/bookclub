package com.tjv.project.bookclub.api.dto.converter;

import com.tjv.project.bookclub.api.dto.MemberDto;
import com.tjv.project.bookclub.domain.Borrowing;
import com.tjv.project.bookclub.domain.Member;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MemberToDtoConverter implements Function <Member, MemberDto> {
    @Override
    public MemberDto apply(Member member) {
        if (member.getBorrowings() == null) {
            return new MemberDto(member.getId(),member.getFirstName(),member.getLastName(),member.getJoinDate(),
                    member.getBalance(), null);
        }

        return new MemberDto(member.getId(),member.getFirstName(),member.getLastName(),member.getJoinDate(),
                member.getBalance(), member.getBorrowings().stream().map(Borrowing::getBorrowingId).toList());
    }
}
