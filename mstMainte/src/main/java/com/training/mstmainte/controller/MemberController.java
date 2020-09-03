package com.training.mstmainte.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.mstmainte.repository.MemberVO;
import com.training.mstmainte.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	HttpServletResponse response;
	
	@RequestMapping(value = "/loginMember", method = RequestMethod.GET)
	public String loginMember() {
		String url = "/member/login_member";
		
		return url;
	}
	
	@RequestMapping(value = "/loginedMember", method = RequestMethod.POST)
	public String loginedMember(@RequestParam("inputId")String inputId,
							    @RequestParam("inputPass")String inputPass,
							    Model model) {
		String url = "redirect:/board/boardList"; // 리다이렉트는 컨트롤러 내 맵핑 주소
		int memberNumber = -1;
		//System.out.println("id : "+inputId +" pass : "+inputPass);
		
		MemberVO memberVO = memberService.loginMember(inputId, inputPass);
		
		if(memberVO.getMemberNumber() != -1) {
			session = request.getSession();/*session을 요청*/
			session.setAttribute("loginMember", memberVO);/*session에 loginMember이름으로 memberVO를 등록*/
			model.addAttribute("message", "ログインしました。");/*jsp로 객체를 전송*/
		} else if(memberNumber == -1) {
			model.addAttribute("message", "IDやPassが間違っています。");/*jsp로 객체를 전송*/
			url = "redirect:/member/loginMember"; // 리다이렉트는 컨트롤러 내 맵핑 주소
		}
		
		return url;
	}
	
	//로그아웃
	@RequestMapping(value = "/logoutMember", method = RequestMethod.GET)
	public String logout(Model model) {
		String url = "redirect:/board/boardList"; // 리다이렉트는 컨트롤러 내 맵핑 주소
		session = request.getSession();//세션을 가져옴
		session.invalidate();//세션 제거
		model.addAttribute("message", "ログアウトしました。");
		
		return url;		
	}

}
