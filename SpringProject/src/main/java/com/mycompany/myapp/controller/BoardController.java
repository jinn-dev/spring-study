package com.mycompany.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/board/openBoardList")
	public ModelAndView openBoardList(Map<String, Object> commandMap) {
		ModelAndView mv = new ModelAndView("/board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		mv.addObject("list", list);
		return mv;
	}
	
	
}
