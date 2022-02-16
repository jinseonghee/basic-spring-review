package com.example.hellospring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberservice;
	MemoryMemberRepository memberRepository;

	@BeforeEach //각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어준다.
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberservice = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	public void 회원가입() {

		//given
		Member member = new Member();
		member.setName("hello!!!");

		//when
		Long saveId = memberservice.join(member);

		//then
		Member findMember = memberservice.findOne(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void 중복_회원_예외() {

		//given
		Member member1 = new Member();
		member1.setName("spring");

		Member member2 = new Member();
		member2.setName("spring");

		//when
		memberservice.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberservice.join(member2));

		// try {
		// 	memberservice.join(member2);
		// 	fail();
		// } catch (IllegalStateException e) {
		// 	assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
		// }

		//then
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
}