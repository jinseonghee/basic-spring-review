package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberservice;

	@Autowired //생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.
	public MemberController(MemberService memberservice) {
		this.memberservice = memberservice;
	}

	@GetMapping("/members/new")
	public String create() {
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(MemberForm form) {

		Member member = new Member();
		member.setName(form.getName());

		memberservice.join(member);

		//System.out.println("member = " + form.getName());

		return "redirect:/";
	}

	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberservice.findMembers(); //findMembers는 모든 member를 불러
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
