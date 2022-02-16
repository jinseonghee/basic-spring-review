package com.example.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import com.example.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberservice(){
		return new MemberService(memberRepository());
	}

	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
