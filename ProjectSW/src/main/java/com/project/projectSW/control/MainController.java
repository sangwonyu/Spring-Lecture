package com.project.projectSW.control;

import javax.inject.Inject;

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
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}
	@RequestMapping("/login.do")
	public String idCheck(@ModelAttribute MemberDTO dto, Model model) {
		System.out.println(dto.toString());
		boolean result =memberService.checkPw(dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인: " + result);
		if(result) {
			model.addAttribute("list", memberService.memberList());
			return "member/member_list";
		}else {
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "home";
		}
	}
}
