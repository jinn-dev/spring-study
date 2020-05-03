package com.example.demo4;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//1-2. MyEvent를 수신할 이벤트 핸들러 생성
@Component
public class MyEventHandler implements ApplicationListener<MyEvent>{
	
	//5-2. 비동기적 실행 대상 이벤트의 메소드에 @Async 어노테이션 사용해야 함(@Order는 의미없어짐)
	@Override
	@Async
	public void onApplicationEvent(MyEvent event) {
		System.out.println(Thread.currentThread().toString());
		System.out.println("My Event Handler: "+event.getData());
	}

}
