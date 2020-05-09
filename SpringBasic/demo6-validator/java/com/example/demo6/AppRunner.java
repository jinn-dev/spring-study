package com.example.demo6;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@Component
public class AppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Event event = new Event();
		EventValidator eventValidator = new EventValidator();
		Errors errors = new BeanPropertyBindingResult(event, "event");
		
		eventValidator.validate(event, errors);
		
		System.out.println(errors.hasErrors());
	
		for(ObjectError e : errors.getAllErrors()) {
			System.out.println("====error code====");
			for(String errMsg : e.getCodes()) {
				System.out.println(errMsg);
			}
			System.out.println(e.getDefaultMessage());
		}
	}

}
