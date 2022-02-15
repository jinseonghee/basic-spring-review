package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	//정적 컨텐츠
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!!");

		return "hello";
	}

	//MVC와 템플릿 엔진
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);

		return "hello-template";
	}

	//API
	@GetMapping("hello-string")
	@ResponseBody //여기서 Body는 http header와 body 부분의 body를 뜻하고 이 annotation을 사용하면 response를 json형식의 key value로 받는 다는 의미
	public String helloString(@RequestParam("name") String name) {

		return "hello " + name; //template 엔진을 거치지 않고 @ResponseBody annotaion을 보고  HTTP의 BODY에 문자 내용을 직접 반환
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name){

		Hello hello = new Hello();
		hello.setName(name);

		return hello; //@ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨
	}

	static class Hello {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
