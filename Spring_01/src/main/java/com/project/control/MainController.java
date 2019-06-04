package com.project.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Spring_01.model.dto.MemberDTO;
import com.project.Service.MemberService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	MemberService memberService;
	@RequestMapping("/login")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		boolean result =memberService.checkPw(
				dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인: " + result);
		if(result) {
			memberService.updateMember(dto);
			return "redirect:/member/list.do";
		}else {
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
}
