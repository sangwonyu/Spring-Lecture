package com.example.Spring_01.service;

import java.util.List;

import com.example.Spring_01.model.dto.MemberDTO;

public interface MemberService {
	
	public List <MemberDTO> memberList();
	public void insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberDTO vo);
	public boolean checkPw(String userid, String passwd);
}
