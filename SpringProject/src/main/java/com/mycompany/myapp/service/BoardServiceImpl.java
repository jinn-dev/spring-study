package com.mycompany.myapp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) {
		boardDAO.insertBoard(map);
	}
	
}
