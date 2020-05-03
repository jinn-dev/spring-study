package com.example.demo2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	///////////////////////////////////////
	//해당 타입의 빈이 여러개인 경우  - 2. @Qualifier 아이디 이름은 스몰 케이스로 시작하는 클래스명
	//@Primary가 좀 더 type safe 하다.
	/*
	@Autowired @Qualifier("yourBookRepositry")
	BookRepository bookRepository;
	
	public void printBookRepository() {
		System.out.println(bookRepository.getClass());
	}
	*/
	
	//해당 타입의 빈이 여러개인 경우 - 3. 복수의 빈을 받는 경우
	/*
	@Autowired
	List<BookRepository> bookRepositories;
	
	public void printBookRepository() {
		
		this.bookRepositories.forEach(BookRepository -> System.out.println(BookRepository));
	}
	*/
	
	//Autowired는 1.타입 2.이름 순으로 확인한다.
	//이름으로 의존성 주입하려면 객체 이름을 해당 클래스명으로 변경하면 된다.
	//bookRepositroy -> myBookRepository로 변경
	/*
	@Autowired
	BookRepository myBookRepository;
	
	public void printBookRepository() {
		System.out.println(myBookRepository.getClass());
	}
	*/
	
	
	@Autowired
	BookRepository myBookRepository;
	
	//BeanPostProcessor
	//AutowiredAnnotationBeanPostProcessor (이것도 bean으로 등록되어 있다.)
	@PostConstruct
	public void setup() {
		System.out.println(myBookRepository.getClass());
	}
	
	///////////////////////////////////////
	
	///////////////////////////////////////
	//1. 생성자에 사용(스프링 4.3부터는 생략 가능
	//생성자의 경우 의존성 주입이 실패하면 해당 클래스의 인스턴스도 생성이 안되므로
	//required 옵션을 쓸 수 없다. 
	/*
	BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	*/
	
	//2. 세터에 사용 (required가 false면 의존성 주입 실패 무시)
	/*
	BookRepository bookRepository;
	
	@Autowired(required = false)
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	*/
	
	//3. 필드에 사용
	/*
	@Autowired(required = false)
	BookRepository bookRepository;
	 */
	///////////////////////////////////////
	
	
}
