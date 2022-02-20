package com.example.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hellospring.repository.JpaMemberRepository;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	//private final DataSource dataSource;
	//private final EntityManager em;
	private final MemberRepository memberRepository;


	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberservice(){
		return new MemberService(memberRepository);
	}

	// @Bean
	// public MemberRepository memberRepository() {
	// 	//return new MemoryMemberRepository();
	// 	//return new JdbcMemberRepository(dataSource); //개방-폐쇄 원칙(OCP, Open-Closed Principle) 확장에는 열려있고, 수정, 변경에는 닫혀있다.
	// 	//return new JdbcTemplateMemberRepository(dataSource);
	// 	return new JpaMemberRepository(em);
	// }
}
