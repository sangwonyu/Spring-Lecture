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
	public int insertMember(MemberDTO vo) {
		String id=vo.getUserid();
		System.out.println("idCheck(MemberDAOImple) : " + id);
		int idCheck = sqlSession.selectOne("board.memberPick",id);
		System.out.println("idCheckCheck : " + idCheck);
		if(idCheck==0) {
			sqlSession.insert("board.insertId",vo);
		}
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
		System.out.println("dao check");
		boolean result = false;
		Map<String,String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		System.out.println(userid + " , "+ passwd);
		int count = sqlSession.selectOne("board.checkPw",map);
		System.out.println("countCheck : " + count );
		if(count==1) {
			System.out.println(count +" : check");
			result=true;
		}
		return result;
	}

}
