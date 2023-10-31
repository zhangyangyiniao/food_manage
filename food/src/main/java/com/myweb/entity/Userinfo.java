package com.myweb.entity;



public class Userinfo {
	private Integer userid;
	private String usercode;
	private String userpwd;
	private String nickname;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Userinfo(Integer userid, String usercode, String userpwd, String nickname) {
		super();
		this.userid = userid;
		this.usercode = usercode;
		this.userpwd = userpwd;
		this.nickname = nickname;
	}
	public Userinfo() {
		super();
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", usercode=" + usercode + ", userpwd=" + userpwd + ", nickname="
				+ nickname + "]";
	}
	
}

