package com.hwig.admin.MLogin;

import java.sql.Date;

public class MLoginVO {
	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_name;
	private String mem_address;
	private String mem_email;
	private Date mem_regdate;
	private String mem_grade;
	private int mem_reverse;
	private int mem_price;

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

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public Date getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	public String getMem_grade() {
		return mem_grade;
	}

	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}

	public int getMem_reverse() {
		return mem_reverse;
	}

	public void setMem_reverse(int mem_reverse) {
		this.mem_reverse = mem_reverse;
	}

	public int getMem_price() {
		return mem_price;
	}

	public void setMem_price(int mem_price) {
		this.mem_price = mem_price;
	}

}
