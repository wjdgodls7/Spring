package com.icia.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberdao;

	public ModelAndView insertDB(MemberDTO member) {
		memberdao.insertDB(member);
		return null;
	}
}
