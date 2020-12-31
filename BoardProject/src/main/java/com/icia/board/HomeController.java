package com.icia.board;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;


@Controller
public class HomeController {
	ModelAndView mav;
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value="/boardwrite")
	public String boardwrite() {
		return "BoardWrite";
	}

	@RequestMapping(value="/board-write")
	public ModelAndView boardwriteform(@ModelAttribute BoardDTO dto) {
		mav = boardservice.boardwriteform(dto);
		return mav;
	}
	@RequestMapping(value="/boardlist")
	public ModelAndView boardlistform() {
		mav = boardservice.boardlistform();
		return mav;
	}
	@RequestMapping(value="/boarddtail")
	public ModelAndView boarddtail(@ModelAttribute BoardDTO bnum) {
		mav = boardservice.boarddtail(bnum);
		return mav;
	}
	
	
}
