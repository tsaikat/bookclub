package com.tjv.project.bookclub.dao;


import com.tjv.project.bookclub.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
