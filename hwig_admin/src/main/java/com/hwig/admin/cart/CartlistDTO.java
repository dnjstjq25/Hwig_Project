package com.hwig.admin.cart;

public class CartlistDTO {
	
	private int prd_id;
	private String prd_name;
	private int prd_price;
	private int order_count;
	private String prd_thumb;
	private String prd_comment;
	private int prd_stock;
	private double prd_sale;
	private String prd_ea;
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
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
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public String getPrd_thumb() {
		return prd_thumb;
	}
	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}
	public String getPrd_comment() {
		return prd_comment;
	}
	public void setPrd_comment(String prd_comment) {
		this.prd_comment = prd_comment;
	}
	public int getPrd_stock() {
		return prd_stock;
	}
	public void setPrd_stock(int prd_stock) {
		this.prd_stock = prd_stock;
	}
	public double getPrd_sale() {
		return prd_sale;
	}
	public void setPrd_sale(double prd_sale) {
		this.prd_sale = prd_sale;
	}
	public String getPrd_ea() {
		return prd_ea;
	}
	public void setPrd_ea(String prd_ea) {
		this.prd_ea = prd_ea;
	}
	
	@Override
	public String toString() {
		return "CartlistDTO [prd_id=" + prd_id + ", prd_name=" + prd_name + ", prd_price=" + prd_price
				+ ", order_count=" + order_count + ", prd_thumb=" + prd_thumb + ", prd_comment=" + prd_comment
				+ ", prd_stock=" + prd_stock + ", prd_sale=" + prd_sale + ", prd_ea=" + prd_ea + "]";
	}
}
