package com.example.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

@Component
public class AppRunner2 implements ApplicationRunner {

	//스프링부트 2.0.5 버전 이상 부터 LocalValidatorFactoryBean으로 자동 등록 되있음
	//EventValidator 대신 Validator를 의존성 주입 받아서 사용할 수 있다.
	@Autowired
	Validator validator;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(validator.getClass());

		Event2 event = new Event2();

		// 임의 Validation error를 발생하기 위해 값 설정
		event.setLimit(-1);
		event.setEmail("abc");

		// EventValidator eventValidator = new EventValidator();
		Errors errors = new BeanPropertyBindingResult(event, "event");

		// eventValidator.validate(event, errors);
		validator.validate(event, errors);

		System.out.println(errors.hasErrors());

		for (ObjectError e : errors.getAllErrors()) {
			System.out.println("====error code2====");
			for (String errMsg : e.getCodes()) {
				System.out.println(errMsg);
			}
			System.out.println(e.getDefaultMessage());
		}
	}
}
