package com.mycompany.myapp.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.common.dao.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		
		return (List<Map<String, Object>>)selectList("board.selectBoardList", map);
	}

	public void insertBoard(Map<String, Object> map) {
		insert("board.insertBoard", map);
	}

}