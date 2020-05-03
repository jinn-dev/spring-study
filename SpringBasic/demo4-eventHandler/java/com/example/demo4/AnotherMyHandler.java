package com.example.demo4;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class AnotherMyHandler {
	
	//3. 같은 이벤트에 다수의 핸들러가 존재할 경우 @Order 어노테이션을 사용
	@EventListener
	@Order(Ordered.LOWEST_PRECEDENCE)
	@Async
	public void handleMyHandle(MyEvent event) {
		System.out.println(Thread.currentThread().toString());
		System.out.println("Another My Event Handler: "+event.getData());
	}
	
	//4. 여러 스프링 기본 이벤트
	//4-1. ApplicationContext가 초기화 및 리프레시 할 때 발생
	@EventListener
	public void handleMyHandle(ContextRefreshedEvent event) {
		System.out.println("ContextRefreshedEvent");
	}
	
	//4-2. ApplicationContext가 start되어 라이프사이클 빈들이 시작신호를 받는 시점에 발생
	@EventListener
	public void handleMyHandle(ContextStartedEvent event) {
		System.out.println("ContextStartedEvent");
	}
	
	//4-3. ApplicationContext가 stop되어 라이프사이클 빈들이 정지신호를 받는 시점에 발생
	@EventListener
	public void handleMyHandle(ContextStoppedEvent event) {
		System.out.println("ContextStoppedEvent");
	}

	//4-4. ApplicationContext가 close되고 빈 소멸되는 시점에 발생
	@EventListener
	public void handleMyHandle(ContextClosedEvent event) {
		System.out.println("ContextClosedEvent");
	}
}
