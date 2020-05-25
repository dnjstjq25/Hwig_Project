  
package com.hwig.admin.member;

public class MemberOrderPrdVO {

	private String prd_name;
	private int prd_price;
	private int order_count;
	private String order_id;

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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "MemberOrderPrdVO [prd_name=" + prd_name + ", prd_price=" + prd_price + ", order_count=" + order_count
				+ ", order_id=" + order_id + "]";
	}

}