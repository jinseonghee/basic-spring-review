package com.example.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.hellospring.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberservice;

	@Autowired //생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.
	public MemberController(MemberService memberservice) {
		this.memberservice = memberservice;
	}
}
