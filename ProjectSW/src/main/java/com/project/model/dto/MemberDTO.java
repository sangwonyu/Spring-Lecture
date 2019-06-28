package com.project.model.dto;
import java.util.Date;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String name;
	private Date join_date;
	private String inception;
	
	public MemberDTO(String userid, String passwd, String name, Date join_date, String inception) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.join_date = join_date;
		this.inception = inception;
	}
	public MemberDTO() {}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getInception() {
		return inception;
	}
	public void setInception(String inception) {
		this.inception = inception;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", join_date=" + join_date
				+ ", inception=" + inception + "]";
	}
	
}