package com.mycompany.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.CommandMap;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView openBoardList(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("/board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap.getMap());
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/board/write")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		return mv;
	}
	
	@RequestMapping("/board/insert")
	public ModelAndView insertBoard(CommandMap commandMap) {
		ModelAndView mv = new ModelAndView("redirect:/board/list");
		boardService.insertBoard(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView selectDetailBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		return mv;
	}
	
	
}
