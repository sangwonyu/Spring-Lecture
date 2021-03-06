package com.project.model.dao;
import java.util.List;

import com.project.model.dto.MemberDTO;


public interface MemberDAO {
	public List <MemberDTO> memberList();
	public int insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberDTO vo);
	public boolean checkPw(String userid, String passwd);
}
