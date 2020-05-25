package com.hwig.admin.order;

public class OrderVO {

	private String order_id;
	private String mem_id;
	private String order_status; // 이건 DB에서
	private int order_reverse;
	private int order_used_reverse;
	private int order_paymoney;
	private String order_payway;
	private String order_paydate;
	private String order_request;

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

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getOrder_reverse() {
		return order_reverse;
	}

	public void setOrder_reverse(int order_reverse) {
		this.order_reverse = order_reverse;
	}

	public int getOrder_used_reverse() {
		return order_used_reverse;
	}

	public void setOrder_used_reverse(int order_used_reverse) {
		this.order_used_reverse = order_used_reverse;
	}

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	public String getOrder_payway() {
		return order_payway;
	}

	public void setOrder_payway(String order_payway) {
		this.order_payway = order_payway;
	}

	public String getOrder_paydate() {
		return order_paydate;
	}

	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}

	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", mem_id=" + mem_id + ", order_status=" + order_status
				+ ", order_reverse=" + order_reverse + ", order_used_reverse=" + order_used_reverse
				+ ", order_paymoney=" + order_paymoney + ", order_payway=" + order_payway + ", order_paydate="
				+ order_paydate + ", order_request=" + order_request + "]";
	}

}
