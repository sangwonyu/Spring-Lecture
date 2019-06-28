package com.project.projectSW.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Service.MemberService;
import com.project.model.dto.MemberDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	HttpServletResponse response;
	@Inject
	MemberService memberService;

	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}

	@RequestMapping("/joinMember.do")
	public String joinMember(@ModelAttribute MemberDTO dto, Model model){
		System.out.println("memberDTO: " + dto.toString());
		if (memberService.insertMember(dto) == 0) {
			System.out.println("여기 체크");
			model.addAttribute("list", memberService.memberList());
			model.addAttribute("userid",dto.getUserid());
			return "member/member_list";
		} else {
			model.addAttribute("message", "아이디가 중복됩니다.");
			return "member/Join";
		}
	}
	
	@RequestMapping("/join.do")
	public String join(Model model) {
		return "member/Join";
	}

	@RequestMapping("/login.do")
	public String idCheck(@ModelAttribute MemberDTO dto, Model model) {
		System.out.println(dto.toString());
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인: " + result);
		if (result) {
			System.out.println(memberService.memberList().toString());
			model.addAttribute("list", memberService.memberList());
			model.addAttribute("userid",dto.getUserid());
			return "member/member_list";
		} else {
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "home";
		}
	}
}
