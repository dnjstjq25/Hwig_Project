package com.hwig.admin.order;

import com.hwig.admin.common.CommonResponse;

public class OrderRegisterResponse extends CommonResponse {

	private String order_id;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "OrderRegisterResponse [order_id=" + order_id + "]";
	}

}
