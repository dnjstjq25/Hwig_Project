package com.hwig.admin;

public class ProductListVO {

	private String prd_name;
	private int prd_stock;
	private int prd_price;
	private String prd_from;
	private String prd_date;

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public int getPrd_stock() {
		return prd_stock;
	}

	public void setPrd_stock(int prd_stock) {
		this.prd_stock = prd_stock;
	}

	public int getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}

	public String getPrd_from() {
		return prd_from;
	}

	public void setPrd_from(String prd_from) {
		this.prd_from = prd_from;
	}

	public String getPrd_date() {
		return prd_date;
	}

	public void setPrd_date(String prd_date) {
		this.prd_date = prd_date;
	}

	@Override
	public String toString() {
		return "ProductListVO [prd_name=" + prd_name + ", prd_stock=" + prd_stock + ", prd_price=" + prd_price
				+ ", prd_from=" + prd_from + ", prd_date=" + prd_date + "]";
	}

}
