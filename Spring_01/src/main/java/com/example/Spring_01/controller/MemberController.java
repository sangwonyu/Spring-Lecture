package com.example.Spring_01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring_01.model.dto.MemberDTO;
import com.example.Spring_01.service.MemberService;

@Controller //현재 클래스를 Controller bean 으로 등록시킴
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//의존성 주입
	@Inject
	MemberService memberService;

	//회원가입 클릭 시 > MemberDAOImpl의 MemberList를 실행
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		logger.info("--Test--");
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	
	//@ModelAttribute에 폼에서 입력한 데이터가 저장됨.
	@RequestMapping("member/insert.do") // 사용자가 요청한 주소 
	public String insert(@ModelAttribute MemberDTO dto) {
		//@ModelAttribute MemberDTO dto을 사용하면 일일이 request.getParameter로 값을 전달하지 않아도 됨.
		memberService.insertMember(dto);
		return "redirect:/member/list.do";
		//만약 redirect를 붙이지 않으면 포워드가 되어 주소가 바뀌지 않음
	}
	
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto",memberService.viewMember(userid));
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
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
	
	@RequestMapping("member/delete.do")
	public String delete(@ModelAttribute MemberDTO dto, Model model, String userid) {
		boolean result =memberService.checkPw(
				dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인: " + result);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
		}else {
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
	
	//@ModelAttribute는 폼의 전체 데이터를 전달함. 즉 dto
	//@RequestParam는 폼의 개별 데이터를 전달함
}
