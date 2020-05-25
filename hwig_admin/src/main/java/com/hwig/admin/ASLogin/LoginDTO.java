package com.hwig.admin.ASLogin;

public class LoginDTO {

	private String user_type;
	private String user_id;
	private String user_pw;

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	@Override
	public String toString() {
		return "LoginDTO [user_type=" + user_type + ", user_id=" + user_id + ", user_pw=" + user_pw + "]";
	}

}
