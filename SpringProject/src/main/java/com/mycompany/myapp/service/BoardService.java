package com.mycompany.myapp.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> commandMap);

	void insertBoard(Map<String, Object> map);
	
}