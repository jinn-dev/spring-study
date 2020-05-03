package com.example.demo;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
//		//application.xml에 등록한 bean을 조회해본다.
//		//ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//		
		//자바설정파일에서 등록한 bean을 조회한다. 
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.deepToString(beanDefinitionNames));
		
		//bookService에서 setter로 bookRespository 객체가 잘 주입되었는지 확인한다.
		BookService bookService = (BookService) context.getBean("bookService");
		System.out.println(bookService.bookRepository != null);
		
	}	

}
