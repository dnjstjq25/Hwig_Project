package com.hwig.admin.product;

public class ProductDTO {

	private int prd_id;
	private String category_name;
	private String sel_cname;
	private String prd_name;
	private int prd_price;
	private String prd_comment;
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getSel_cname() {
		return sel_cname;
	}
	public void setSel_cname(String sel_cname) {
		this.sel_cname = sel_cname;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public String getPrd_comment() {
		return prd_comment;
	}
	public void setPrd_comment(String prd_comment) {
		this.prd_comment = prd_comment;
	}
	@Override
	public String toString() {
		return "ProductDTO [prd_id=" + prd_id + ", category_name=" + category_name + ", sel_cname=" + sel_cname
				+ ", prd_name=" + prd_name + ", prd_price=" + prd_price + ", prd_comment=" + prd_comment + "]";
	}
	
}
