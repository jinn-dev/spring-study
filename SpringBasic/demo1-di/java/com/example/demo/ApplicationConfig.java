package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//2. @Component 스캐닝을 이용해 bean을 등록하는 방법 (스프링 2.5부터 가능) ex. Service, Repository
//@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

// 1. Bean을 여기서 직접 해준 경우
	@Bean
	public BookRepository bookRepository() {
		return new BookRepository();
	}
	
	//여기서 의존성주입을 직접 해준 경우 (setter를 썼을 경우에만 가능)
	/*
	@Bean
	public BookService bookService() {
		BookService bookService = new BookService();
		bookService.setBookRepository(bookRepository());
		return bookService;
	}
	*/
	
	//@Autowired로 의존성주입을 해준 경우
	@Bean
	public BookService bookService() {
		return new BookService();
	}
	
}
