package com.project.Service;

import java.util.List;

import com.example.Spring_01.model.dto.MemberDTO;
import com.project.model.dao.MemberDAO;

public class MemberServiceImple implements MemberService {
	MemberDAO memberDao;
	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return memberDao.checkPw(userid,passwd);
	}
}
