package com.hwig.admin.seller;

public class SellerPwDTO {

	private String sel_id;
	private String sel_pw;

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

	@Override
	public String toString() {
		return "SellerPwDTO [sel_id=" + sel_id + ", sel_pw=" + sel_pw + "]";
	}

}
