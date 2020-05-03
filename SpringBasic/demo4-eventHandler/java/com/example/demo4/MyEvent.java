package com.example.demo4;

import org.springframework.context.ApplicationEvent;

//1-1. 이벤트 객체 생성
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {

	private int data;
	
	public MyEvent(Object source) {
		super(source);
	}

	public MyEvent(Object source, int data) {
		super(source);
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}	
}
