package com.hwig.admin;

public class OrderListVO {

	private String order_id;
	private String mem_id;
	private String prd_name;
	private int order_paymoney;
	private String order_status;
	private String order_request;
	private String order_paydate;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
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

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}

	public String getOrder_paydate() {
		return order_paydate;
	}

	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}

	@Override
	public String toString() {
		return "OrderListVO [order_id=" + order_id + ", mem_id=" + mem_id + ", prd_name=" + prd_name
				+ ", order_paymoney=" + order_paymoney + ", order_status=" + order_status + ", order_request="
				+ order_request + ", order_paydate=" + order_paydate + "]";
	}

}
