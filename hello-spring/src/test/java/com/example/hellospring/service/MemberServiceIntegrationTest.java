package com.example.hellospring.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional //테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
class MemberServiceIntegrationTest {

	@Autowired MemberService memberservice;
	@Autowired MemberRepository memberRepository;

	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberservice = new MemberService(memberRepository);
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