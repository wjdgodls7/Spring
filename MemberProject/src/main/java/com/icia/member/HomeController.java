package com.icia.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;


@Controller
public class HomeController {
	ModelAndView mav;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	@RequestMapping(value="/memberJoin")
	public String memberJoin(@ModelAttribute MemberDTO member) {
		mav = memberService.insertDB(member);
		
		
		return "MemberLogin";
	}
	
}
