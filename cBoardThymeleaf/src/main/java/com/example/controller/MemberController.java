package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	// 선택한 페이지로 이동
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "/member/" + step;
	}

	/*
	 * 함수명 : register 인자 : MemberVO 역할 : 정해진 폼에 입력한 데이터를 MemberVO로 전달받아, 이를
	 * DATABASE에 입력
	 *
	 */
	@RequestMapping("/register")
	public String register(MemberVO vo, Model m) {
		int result = service.register(vo);
		String message = "";
		if (result == 1) {
			message = ("회원 가입 성공");
			System.out.println(message);
			m.addAttribute("message", message);
			return "member/loginForm";
		} else {
			message = "회원가입 실패";
			System.out.println(message);
			m.addAttribute("message", message);
			return "redirect:member/insertMemberForm";
		}

	}

	/*
	 * 함수명 : login 
	 * 인자 : id,pass 
	 * 역할 : 사용자가 입력한 아이디와 비밀번호를 전달받아 일치하는 정보가 DB에 있는경우, 일치하는 데이터를 가져옴
	 * 
	 */
	@RequestMapping("/login")
	public String login(MemberVO vo, Model m, HttpSession session) {
		MemberVO result = service.login(vo);
		System.out.println("로그인 호출");
		if (result != null) {
			//System.out.println(result.getUserid()+"/"+result.getUsername());
			m.addAttribute("user", result);
			session.setAttribute("user", result);			
			return "member/loginSuccess";
		} else {
			return "member/loginForm";
		}
	}

	/*
	 * 함수명 : logout 인자 : session 역할 : 로그아웃 버튼 눌렀을 때 세션 초기화
	 * 
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃");
		return "member/loginForm";

	}
}
