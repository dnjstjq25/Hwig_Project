package com.hwig.admin.member;

public class IdNameEmailCheckVO {

	private String mem_id;
	private String mem_name;
	private String mem_email;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	@Override
	public String toString() {
		return "IdNameEmailCheckDTO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_email=" + mem_email + "]";
	}

}
