package com.example.demo7;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
	//Controller에 사용할 Binder를 등록하는 방법
	//webDataBinder는 DataBinder의 구현체 중 하나
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Event.class, new EventEditor());
	}
	
	@GetMapping("/event/{event}")
	public String getEvent(@PathVariable Event event) {
		System.out.println(event);
		
		return event.getId().toString();
	}
}
