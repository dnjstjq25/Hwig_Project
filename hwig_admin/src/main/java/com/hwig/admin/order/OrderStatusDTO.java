package com.hwig.admin.order;

public class OrderStatusDTO {

	private String order_status;

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "OrderStatusDTO [order_status=" + order_status + "]";
	}

}
