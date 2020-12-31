package com.icia.member;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;


@Controller
public class HomeController {
	ModelAndView mav;
	@Autowired
	private MemberService memberService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value="/memberJoin")
	public String memberJoin(@ModelAttribute MemberDTO member) {
		mav = memberService.insertDB(member);
		return "MemberLogin";
	}
	@RequestMapping(value="/memberLogin")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		mav = memberService.selectDB(member);
		return mav;
	}
	@RequestMapping(value="/memberlogin")
	public String memberLoginpage() {
		return "MemberLogin";
	}
	@RequestMapping(value="/memberList")
	public ModelAndView memberlist() {
		mav = memberService.SelectList();
		return mav;
	}
	@RequestMapping(value="/memberdetail")
	public ModelAndView memberdetail(@RequestParam("detail") String detail) {
		mav = memberService.SelectDetail(detail);
		return mav;
	}
	@RequestMapping(value="/memberDel")
	public ModelAndView memberDel(@RequestParam("delid") String del) {
		mav = memberService.Delete(del);
		return mav;
	}
	@RequestMapping(value="/memberUpdate")
	public ModelAndView memberUpdate(@RequestParam("ids") String detail) {
		mav = memberService.Select(detail);
		return mav;
	}
	@RequestMapping(value="/memberUpdateProcess")
	public ModelAndView memberUpdateProcess(@ModelAttribute MemberDTO dto) {
		System.out.println(dto.getMid());
		mav = memberService.MemberUpdate(dto);
		return mav;
	}
	@RequestMapping(value="/memberlogout")
	public String memberlogout() {
		session.invalidate();
		return "home";
	}
	@RequestMapping(value="/idoverlap")
	public @ResponseBody String idOverlap(@RequestParam("mid") String mid) {
		System.out.println("mid : " + mid);
		String result = memberService.idOverlap(mid);		
		return result;
	}
	@RequestMapping(value="/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(@RequestParam("mid") String mid) {
		MemberDTO member = memberService.memberViewAjax(mid);
		return member;
	}
}
