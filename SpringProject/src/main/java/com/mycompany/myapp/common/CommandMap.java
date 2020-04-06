package com.mycompany.myapp.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// request에 담겨있는 파라미터를 Map에 담아주는 역할
// HandlerMethodArgumentResolver는 컨트롤러의 파라미터가 Map형식이면 동작하지 않는다.
// Map형식이면 내가 설정한 클래스가 아니라 스프링에서 기본적으로 설정된 ArgumentResolver를 거치게 된다.
// <mvc:annotation-driven/> 설정하면 위와 같이 동작한다.
public class CommandMap {
	Map<String, Object> map = new HashMap<String, Object>();

	public Object get(String key) {
		return map.get(key);
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public Object remove(String key) {
		return map.remove(key);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public void clear() {
		map.clear();
	}

	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}

	public Map<String, Object> getMap() {
		return map;
	}

}
