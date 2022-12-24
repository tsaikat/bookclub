package com.tjv.project.bookclub.service;

import com.tjv.project.bookclub.dao.MemberRepository;
import com.tjv.project.bookclub.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberService extends CrudService<Member, Long> {


    public MemberService(MemberRepository repository) {
        super(repository);
    }

    @Override
    protected Long id(Member e) {
        return e.getId();
    }

    @Override
    public Member create (Member e) {
        e.setJoinDate(LocalDateTime.now());
        return repository.save(e);
    }
}
