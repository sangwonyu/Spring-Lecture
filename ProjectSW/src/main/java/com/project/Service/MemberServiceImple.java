package com.project.Service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.model.dao.MemberDAO;
import com.project.model.dto.MemberDTO;

@Service
public class MemberServiceImple implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImple.class);
	@Inject
	MemberDAO memberDao;
	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public int insertMember(MemberDTO vo) {
		int idCheck = memberDao.insertMember(vo);
		return idCheck;
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
		System.out.println("serviceCheckPw");
		return memberDao.checkPw(userid,passwd);
	}

}
