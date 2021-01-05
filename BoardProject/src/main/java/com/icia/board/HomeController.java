package com.icia.board;

import java.io.IOException;
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
	public ModelAndView boardwriteform(@ModelAttribute BoardDTO dto) throws IllegalStateException, IOException {
		mav = boardservice.boardwriteform(dto);

		return mav;
	}
	//	@RequestMapping(value="/boardlist")
	//	public ModelAndView boardlistform() {
	//		mav = boardservice.boardlistform();
	//		return mav;
	//	}
	@RequestMapping(value="/boarddetail")
	public ModelAndView boarddetail(@ModelAttribute BoardDTO bnum, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = boardservice.boarddtail(bnum,page);
		System.out.println(bnum.getBfilename());
		return mav;
	}

	@RequestMapping(value="/boardupdate")
	public ModelAndView boardupdate(@RequestParam("bnum") int bnum) {
		mav.addObject("bnum", bnum);
		mav.setViewName("BoardUpdate");
		return mav;
	}
	@RequestMapping(value="/board-update")
	public ModelAndView boardupdateform(@ModelAttribute BoardDTO dto) {
		mav = boardservice.boardupdateform(dto);
		return mav;
	}


	@RequestMapping(value="/boarddelete")
	public ModelAndView boarddelete(@RequestParam("bnum") int bnum) {
		System.out.println(bnum);
		mav = boardservice.boarddelete(bnum);
		return mav;
	}
	@RequestMapping(value="/boardlist")
	//처음 default값을 1로 주고 다음에 요청받는 값들은 value쪽으로 들어감
	public ModelAndView boardListPage(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = boardservice.boardpaging(page);
		return mav;
	}

	@RequestMapping(value="/boardserch")
	public ModelAndView boardSerch(@RequestParam("serchtype") String serchtype,
			@RequestParam("keyword") String keyword,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = boardservice.boardSerch(serchtype,keyword,page);
		return mav;

	}
}
