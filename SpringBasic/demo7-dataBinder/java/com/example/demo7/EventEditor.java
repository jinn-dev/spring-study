package com.example.demo7;

import java.beans.PropertyEditorSupport;

//해당 구현체는 서로 다른 thread에게 공유가 된다.(Thread Safe 하지 않음)
public class EventEditor extends PropertyEditorSupport {

	//문자열로 들어온 1을 Event 타입으로 변환
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new Event(Integer.parseInt(text)));
	}
	
	@Override
	public String getAsText() {
		Event event = (Event)getValue();
		return event.getId().toString();
	}
}
