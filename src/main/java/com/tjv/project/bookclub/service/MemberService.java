package com.tjv.project.bookclub.service;

import com.tjv.project.bookclub.dao.MemberRepository;
import com.tjv.project.bookclub.domain.Member;
import com.tjv.project.bookclub.exception.IllegalDataException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        if (e.getFirstName() == null || e.getFirstName().isEmpty()
                || e.getLastName() == null || e.getLastName().isEmpty()) {
            throw new IllegalDataException();
        }
        if (e.getBalance() == null) e.setBalance(0L);
        e.setJoinDate(LocalDateTime.now());
        return repository.save(e);
    }

    @Override
    public Member update (Long id, Member e) {
        // only updates the balance
        Member memberToUpdate;
        try {
            memberToUpdate = repository.findById(id).orElseThrow();
        } catch (IllegalArgumentException | NoSuchElementException ex) {
            throw new IllegalDataException();
        }

        memberToUpdate.setBalance(e.getBalance());
        return repository.save(memberToUpdate);
    }
}
