package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import com.example.test.TestService;

@SpringBootApplication
public class Demo2Application {

	@Autowired
	TestService testService;
	
	public static void main(String[] args) {

		new SpringApplicationBuilder().sources(Demo2Application.class)
				.initializers((ApplicationContextInitializer<GenericApplicationContext>) applicationContext -> {
					applicationContext.registerBean(TestService.class);
				}).run(args);

		
		/*
		SpringApplication.run(Demo2Application.class, args);
		*/
	}
	
	/*
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	*/
}
