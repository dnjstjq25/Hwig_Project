package com.hwig.admin.member;

public class MemberDeleteVO {

	private String order_id;
	private String order_status;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "MemberDeleteVO [order_id=" + order_id + ", order_status=" + order_status + "]";
	}

}
