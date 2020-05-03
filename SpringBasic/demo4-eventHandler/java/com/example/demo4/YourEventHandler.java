package com.example.demo4;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class YourEventHandler {
	
	//2-2. ApplicationListener 상속 대신 @EventListener 어노테이션 사용
	@EventListener
	@Async
	public void handleYourEvent(YourEvent event) {
		System.out.println(Thread.currentThread().toString());
		System.out.println("Your Event Handler: "+event.getData());
	}
}
