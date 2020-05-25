package com.hwig.admin.seller;

public class StockPrdsVO {

	private int prd_id;
	private String prd_name;
	private int prd_stock;
	private int prd_price;
	private String prd_from;
	private String prd_info;
	private String prd_date;

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

	public String getPrd_info() {
		return prd_info;
	}

	public void setPrd_info(String prd_info) {
		this.prd_info = prd_info;
	}

	public String getPrd_date() {
		return prd_date;
	}

	public void setPrd_date(String prd_date) {
		this.prd_date = prd_date;
	}

	@Override
	public String toString() {
		return "StockPrdsVO [prd_id=" + prd_id + ", prd_name=" + prd_name + ", prd_stock=" + prd_stock + ", prd_price="
				+ prd_price + ", prd_from=" + prd_from + ", prd_info=" + prd_info + ", prd_date=" + prd_date + "]";
	}

}
