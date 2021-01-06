package com.icia.example;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example.dto.MemberDTO;
import com.icia.example.service.ExampleService;


@Controller
public class HomeController {

	ModelAndView mav;
	@Autowired
	private ExampleService es;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	@RequestMapping(value="/join")
	public String joinform() {
		return "JoinForm";
	}
	@RequestMapping(value="memberJoin")
	public ModelAndView memberjoin(@ModelAttribute MemberDTO mdto) throws IllegalStateException, IOException {
		mav = es.memberjoin(mdto);
		return mav;

	}
	@RequestMapping(value="idoverlap")
	public @ResponseBody int idoverlap(@RequestParam("mid") String mid) {
		return es.idoverlap(mid);
	}




}

