package com.hwig.admin.product;

public class ProductListDTO {
	private int prd_id;
	private String prd_thumb;
	private String prd_img;
	private String prd_name;
	private String prd_kg;
	private int prd_price;
	private String prd_comment;
	private int category_id;
	private int category_p_id;
	private double prd_sale;
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getPrd_thumb() {
		return prd_thumb;
	}
	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public String getPrd_kg() {
		return prd_kg;
	}
	public void setPrd_kg(String prd_kg) {
		this.prd_kg = prd_kg;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getCategory_p_id() {
		return category_p_id;
	}
	public void setCategory_p_id(int category_p_id) {
		this.category_p_id = category_p_id;
	}
	public double getPrd_sale() {
		return prd_sale;
	}
	public void setPrd_sale(double prd_sale) {
		this.prd_sale = prd_sale;
	}
	
}
