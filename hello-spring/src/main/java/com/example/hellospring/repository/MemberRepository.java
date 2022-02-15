package com.example.hellospring.repository;

import java.util.List;
import java.util.Optional;

import com.example.hellospring.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	Optional<Member> findById(Long id); //자바 8 이상에서 지원, 넘어오는 값이 null이면 한번 null 값을  감싸서 값을 뱉음.
	Optional<Member> findByName(String name);
	List<Member> findAll();

}
