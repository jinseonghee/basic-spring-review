package com.example.hellospring; //이 패키지 하위 까지만 spring이 componentScan을 함. 그래서 그 외에 아무곳에나 @Bean등록 하려면 설정 바꿔줘야 함

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
