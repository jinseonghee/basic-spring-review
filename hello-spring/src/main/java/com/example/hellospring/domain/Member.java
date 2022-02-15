package com.example.hellospring.domain;

public class Member {

	private Long id; //client 실제 아이디가 아닌 서버에서 값을 구분하기 위해 서버에서 지정한 값
	private String name;

	public Long getId() {
		return id; //
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
