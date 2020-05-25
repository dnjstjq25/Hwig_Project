package com.hwig.admin.product;

public class ProductNewDTO {
	private int prd_id;
	private int category_id;
	private String prd_name;
	private String prd_thumb;
	private String prd_price;
	private double prd_sale;
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public String getPrd_thumb() {
		return prd_thumb;
	}
	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}
	public String getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(String prd_price) {
		this.prd_price = prd_price;
	}
	public double getPrd_sale() {
		return prd_sale;
	}
	public void setPrd_sale(double prd_sale) {
		this.prd_sale = prd_sale;
	}
	
	@Override
	public String toString() {
		return "ProductNewDTO [prd_id=" + prd_id + ", category_id=" + category_id + ", prd_name=" + prd_name
				+ ", prd_thumb=" + prd_thumb + ", prd_price=" + prd_price + ", prd_sale=" + prd_sale + "]";
	}
}
