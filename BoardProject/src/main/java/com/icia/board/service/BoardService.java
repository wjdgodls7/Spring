package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
@Service
public class BoardService {
	ModelAndView mav;
	@Autowired
	private BoardDAO dao;
	
	public ModelAndView boardwriteform(BoardDTO dto) {
		mav = new ModelAndView();
		int result =  dao.boardwriteform(dto);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("Fail");
		}
		return mav;
	}

	public ModelAndView boardlistform() {
		mav = new ModelAndView();
		List<BoardDTO> list = dao.boardlistform();
		mav.addObject("list", list);
		mav.setViewName("BoardList");
		return mav;
	}

	public ModelAndView boarddtail(BoardDTO bnum) {
		mav = new ModelAndView();
		BoardDTO result = dao.boarddtail(bnum);
		mav.addObject("list", result);
		mav.setViewName("BoardDetail");
		
		return mav;
	}

}
