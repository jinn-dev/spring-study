package com.example.demo4;

//2-1. Spring 4.2부터 코드 내에 프레임워크 소스가 없는 구조인 POJO 형식으로 이벤트 프로그래밍 가능
//ApplicationEvent를 상속받지 않아도 된다.
public class YourEvent {
	
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public YourEvent(int data) {
		super();
		this.data = data;
	}
	
}
