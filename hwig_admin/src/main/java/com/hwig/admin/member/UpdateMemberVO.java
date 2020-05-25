package com.hwig.admin.member;

public class UpdateMemberVO {

	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_addr;
	private String mem_email;
	private String mem_newpw;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_newpw() {
		return mem_newpw;
	}

	public void setMem_newpw(String mem_newpw) {
		this.mem_newpw = mem_newpw;
	}

	@Override
	public String toString() {
		return "UpdateMemberVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_tel=" + mem_tel + ", mem_addr="
				+ mem_addr + ", mem_email=" + mem_email + ", mem_newpw=" + mem_newpw + "]";
	}

}
