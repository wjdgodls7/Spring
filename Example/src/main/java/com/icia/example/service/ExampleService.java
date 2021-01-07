package com.icia.example.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example.dao.ExampleDAO;
import com.icia.example.dto.MemberDTO;

@Service
public class ExampleService {

	@Autowired
	private ExampleDAO dao;
	
	ModelAndView mav;
	
	public ModelAndView memberjoin(MemberDTO mdto) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		int result = dao.memberjoin(mdto);
		if (result>0) {
			mav.setViewName("home");
		}
		else{
			mav.setViewName("Fail");
		}
		return mav;
	}

	public int idoverlap(String mid) {
		return dao.idoverlap(mid);
	}
	
	
}
