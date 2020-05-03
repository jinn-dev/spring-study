package com.example.demo3;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired 
	MessageSource messageSource;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		while(true) {
			System.out.println(messageSource.getMessage("greeting", new String[] {"지니"}, Locale.KOREA));
			System.out.println(messageSource.getMessage("greeting", new String[] {"Jinny"}, Locale.getDefault()));
			Thread.sleep(1000);
		}
	}	
}
