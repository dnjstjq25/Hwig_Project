package com.hwig.admin.order;

public class OrderDetailPrdDTO {

	private String order_id;
	private int prd_id;
	private String prd_name;
	private int prd_price;
	private int order_count;
	private String sel_cname;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

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

	public String getSel_cname() {
		return sel_cname;
	}

	public void setSel_cname(String sel_cname) {
		this.sel_cname = sel_cname;
	}

	@Override
	public String toString() {
		return "OrderDetailPrdDTO [order_id=" + order_id + ", prd_id=" + prd_id + ", prd_name=" + prd_name
				+ ", prd_price=" + prd_price + ", order_count=" + order_count + ", sel_cname=" + sel_cname + "]";
	}

}
