package com.example.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	ApplicationContext resourceLoader;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//AnnotationConfigApplicationContext
		System.out.println(resourceLoader.getClass()); 
		
		//org.springframework.core.io.ClassPathResource
		Resource resource = resourceLoader.getResource("classpath:test.txt");
		
		//org.springframework.core.io.DefaultResourceLoader$ClassPathContextResource
		//Resource resource = resourceLoader.getResource("test.txt");
		
		System.out.println(resource.getClass()); 
	
		System.out.println("======");
		System.out.println(resource.exists());
		System.out.println(resource.getDescription());
		System.out.println(resource.getURI().getPath());

	}
}
