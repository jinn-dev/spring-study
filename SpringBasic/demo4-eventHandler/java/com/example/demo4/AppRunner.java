package com.example.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//1-3. ApplicationEventPublisher로 이벤트를 발생(ApplicationContext를 상속 받아도 가능)
@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	ApplicationContext appContext;
	//ApplicationEventPublisher publishEvent;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		appContext.publishEvent(new MyEvent(this, 100));
		appContext.publishEvent(new YourEvent(1000));	
		
		((ConfigurableApplicationContext)appContext).close();
	}
}
