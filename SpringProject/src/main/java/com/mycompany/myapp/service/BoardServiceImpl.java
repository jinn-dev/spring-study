package com.mycompany.myapp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycompany.myapp.common.util.FileUtil;
import com.mycompany.myapp.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Resource(name="fileUtil")
	private FileUtil fileUtil;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		boardDAO.insertBoard(map);
		
		List<Map<String, Object>> list = fileUtil.parseInsertFileInfo(map, request);
		for (int i = 0, size = list.size(); i < size; i++) {
			boardDAO.insertFile(list.get(i));
		}
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		return boardDAO.selectBoardDetail(map);
	}

	@Override
	public void updateBoard(Map<String, Object> map) {
		boardDAO.updateBoard(map);
	}

	@Override
	public void deleteBoard(Map<String, Object> map) {
		boardDAO.deleteBoard(map);
	}
	
}
