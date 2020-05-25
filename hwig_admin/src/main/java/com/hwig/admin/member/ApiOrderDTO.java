package com.hwig.admin.member;

public class ApiOrderDTO {

	private String order_paydate;
	private String prd_name;
	private String prd_thumb;
	private int order_count;
	private String order_id;
	private int order_paymoney;
	private String order_status;

	public String getOrder_paydate() {
		return order_paydate;
	}

	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
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

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "ApiOrderDTO [order_paydate=" + order_paydate + ", prd_name=" + prd_name + ", prd_thumb=" + prd_thumb
				+ ", order_count=" + order_count + ", order_id=" + order_id + ", order_paymoney=" + order_paymoney
				+ ", order_status=" + order_status + "]";
	}

}
