package com.hwig.admin.seller;

public class SellerVO {

	private String sel_id;
	private String sel_pw;
	private String sel_cname;
	private String sel_name;
	private String sel_addr;
	private String sel_tel;
	private String sel_img;
	private String origin_img;

	public String getSel_id() {
		return sel_id;
	}

	public void setSel_id(String sel_id) {
		this.sel_id = sel_id;
	}

	public String getSel_pw() {
		return sel_pw;
	}

	public void setSel_pw(String sel_pw) {
		this.sel_pw = sel_pw;
	}

	public String getSel_cname() {
		return sel_cname;
	}

	public void setSel_cname(String sel_cname) {
		this.sel_cname = sel_cname;
	}

	public String getSel_name() {
		return sel_name;
	}

	public void setSel_name(String sel_name) {
		this.sel_name = sel_name;
	}

	public String getSel_addr() {
		return sel_addr;
	}

	public void setSel_addr(String sel_addr) {
		this.sel_addr = sel_addr;
	}

	public String getSel_tel() {
		return sel_tel;
	}

	public void setSel_tel(String sel_tel) {
		this.sel_tel = sel_tel;
	}

	public String getSel_img() {
		return sel_img;
	}

	public void setSel_img(String sel_img) {
		this.sel_img = sel_img;
	}

	public String getOrigin_img() {
		return origin_img;
	}

	public void setOrigin_img(String origin_img) {
		this.origin_img = origin_img;
	}

	@Override
	public String toString() {
		return "SellerVO [sel_id=" + sel_id + ", sel_pw=" + sel_pw + ", sel_cname=" + sel_cname + ", sel_name="
				+ sel_name + ", sel_addr=" + sel_addr + ", sel_tel=" + sel_tel + ", sel_img=" + sel_img
				+ ", origin_img=" + origin_img + "]";
	}

	public void empty() {
		sel_id = "";
		sel_pw = "";
		sel_cname = "";
		sel_name = "";
		sel_addr = "";
		sel_tel = "";
		sel_img = "";
		origin_img = "";
	}

}
