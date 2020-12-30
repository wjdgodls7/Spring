package com.icia.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	ModelAndView mav;
	@Autowired
	private MemberDAO memberdao;
	@Autowired
	private HttpSession session;
	
	public ModelAndView insertDB(MemberDTO member) {
		int result = memberdao.insertDB(member);
		if (result>0) {
			mav.setViewName("MemberLogin");
		}else {
			mav.setViewName("MemberLogin");
		}
		return mav;
	}

	public ModelAndView selectDB(MemberDTO member) {
		mav = new ModelAndView();
		int result = memberdao.selectDB(member);
		System.out.println(result);
		if (result>0) {
			session.setAttribute("loginid", member.getMid());
			mav.addObject("mid", member.getMid());
			mav.setViewName("MemberMain");
		}else {
			mav.setViewName("MemberLogin");
		}
		return mav;
	}

	public ModelAndView SelectList() {
		mav = new ModelAndView();
		List<Object> list = memberdao.selectList();
		mav.addObject("list", list);
		mav.setViewName("MemberList");
		return mav;
	}

	public ModelAndView SelectDetail(String detail) {
		mav = new ModelAndView();
		MemberDTO members = memberdao.SelectDetail(detail);
		mav.addObject("member",members);
		mav.setViewName("MemberDetail");
		return mav;
	}

	public ModelAndView Delete(String del) {
		mav = new ModelAndView();
		int result = memberdao.Delete(del);
		if (result>0) {
			mav.setViewName("redirect:/memberList");	
		}else {
			mav.setViewName("memberList");
		}
		
		return mav;
	}

	public ModelAndView Select(String detail) {
		mav = new ModelAndView();
		MemberDTO dto = memberdao.Detail(detail);
		mav.addObject("detail", dto);
		mav.setViewName("MemberUpdate");
		return mav;
	}

	public ModelAndView MemberUpdate(MemberDTO dto) {
		mav = new ModelAndView();
		int result = memberdao.MemberUpdate(dto);
		if (result>0) {
			session.invalidate();
			mav.setViewName("MemberLogin");
		}
		return mav;
	}
}