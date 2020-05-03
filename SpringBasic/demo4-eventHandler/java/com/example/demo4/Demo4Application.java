package com.example.demo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//5-1. 비동기적 이벤트 수신을 위해 실행 진입점에 @EnableAsync 어노테이션 사용
@SpringBootApplication
@EnableAsync
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

}
