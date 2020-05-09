package com.example.demo6;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		boolean result = false;
		if(Event.class.isAssignableFrom(clazz)) {
			result = true;
		}
		return result;
		//return Event.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "notEmpty", "Empty title is now allowed");
	
		//ValidationUtils 대신 직접 Validation 로직을 추가해서 사용
//		Event event = (Event) target;
//
//		if(event.getTitle() == null) {
//		    errors.reject("notEmpty", "Empty title is now allowed");
//		}
		
	}
}
