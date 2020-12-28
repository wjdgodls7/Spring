package com.icia.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.test.service.TestService;


@Controller
public class HomeController {
	ModelAndView mav;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	
	@RequestMapping(value = "/testview")
	public String test() {
		
		return "test";

	}
	@RequestMapping(value = "/param" )
	public ModelAndView paramTest(@RequestParam("param1") String param1,
								  @RequestParam("param2") String param2) {
		
		System.out.println(param1);
		System.out.println(param2);
		mav = new ModelAndView();
		mav.addObject("par1", param1);
		mav.addObject("par2", param2);
		mav.setViewName("test2");
		return mav;
	}
	
	@RequestMapping(value="/insertDB")
	public void insertDB(@RequestParam("data1") String data1) {
		testService.insertDB(data1);
	}
}