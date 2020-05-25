package com.hwig.admin.order;

public class ApiOrderCompletionDTO {

	private String order_id;
	private String prd_name;
	private String order_receiver_addr;
	private String order_paydate;
	private String order_payway;
	private int order_paymoney;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public String getOrder_receiver_addr() {
		return order_receiver_addr;
	}

	public void setOrder_receiver_addr(String order_receiver_addr) {
		this.order_receiver_addr = order_receiver_addr;
	}

	public String getOrder_paydate() {
		return order_paydate;
	}

	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}

	public String getOrder_payway() {
		return order_payway;
	}

	public void setOrder_payway(String order_payway) {
		this.order_payway = order_payway;
	}

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	@Override
	public String toString() {
		return "ApiOrderCompletionDTO [order_id=" + order_id + ", prd_name=" + prd_name + ", order_receiver_addr="
				+ order_receiver_addr + ", order_paydate=" + order_paydate + ", order_payway=" + order_payway
				+ ", order_paymoney=" + order_paymoney + "]";
	}

}
