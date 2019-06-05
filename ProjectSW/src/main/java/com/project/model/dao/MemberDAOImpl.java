package com.project.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	SqlSession sqlSession;
	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList("board.memberList");
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
		System.out.println("dao check");
		boolean result = false;
		Map<String,String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("board.checkPw",map);
		if(count==1) {
			result=true;
		}
		return result;
	}

}
