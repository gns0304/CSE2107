package kr.ac.inha.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.SystemTray;
import java.awt.print.Printable;
import java.util.HashMap;

import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.dto.MemberDto;
import kr.ac.inha.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/welcome.do")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}
	
//	회원가입 관련
	@RequestMapping("/member/addMember.do")
	public ModelAndView addMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/addMember");
		return mv;
	}
	
	@RequestMapping("/member/processAddMember.do")
	public ModelAndView processAddMember(HttpServletRequest request, MemberDto dto) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/addMember");
		try {
			memberService.addMember(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", dto.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return welcome();
	}
	

	
	// 로그인 관련
	@RequestMapping("/member/loginMember.do")
	public ModelAndView loginMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/loginMember");
		return mv;
	}
	
	@RequestMapping("/member/processLoginMember.do")
	public ModelAndView processLoginMember(HttpServletRequest request, String id, String pw) {

		MemberDto userDto = null;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/processLoginMember");
		
		try {
			userDto = memberService.getUser(id, pw);

		} catch (Exception e) {
			
		}
				
		if (userDto != null){
			HttpSession session = request.getSession();
		
			session.setAttribute("sessionId", userDto.getId());
			return welcome();
			
		} else {
			
			mv.setViewName("member/loginMember");
			mv.addObject("msg", " ");
			return mv;
		}
		
	}
	
	// 로그아웃 관련

	@RequestMapping("/member/logoutMember.do")
	public ModelAndView logoutMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("sessionId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/logoutMember");
		return welcome();
	}
	
	// 회원정보 수정 부분
	
	@RequestMapping("/member/updateMember.do")
	public ModelAndView updateMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto userDto = null;
		
		try {
			userDto = memberService.getUserById(session.getAttribute("sessionId").toString());
			
		} catch (Exception e) {
			return loginMember();
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/updateMember");
		mv.addObject("info", userDto);
		return mv;
	

	}
	
	@RequestMapping("/member/processUpdateMember.do")
	public ModelAndView processUpdateMember(HttpServletRequest request, MemberDto dto) {

		try {
			memberService.updateMember(dto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return welcome();
	

	}
	


	
	
}
