package com.hwig.admin.order;

public class OrderAddrVO {

	private String order_id;
	private String order_sender;
	private String order_receiver;
	private String order_receiver_tel;
	private String order_receiver_addr;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_sender() {
		return order_sender;
	}

	public void setOrder_sender(String order_sender) {
		this.order_sender = order_sender;
	}

	public String getOrder_receiver() {
		return order_receiver;
	}

	public void setOrder_receiver(String order_receiver) {
		this.order_receiver = order_receiver;
	}

	public String getOrder_receiver_tel() {
		return order_receiver_tel;
	}

	public void setOrder_receiver_tel(String order_receiver_tel) {
		this.order_receiver_tel = order_receiver_tel;
	}

	public String getOrder_receiver_addr() {
		return order_receiver_addr;
	}

	public void setOrder_receiver_addr(String order_receiver_addr) {
		this.order_receiver_addr = order_receiver_addr;
	}

	@Override
	public String toString() {
		return "OrderAddrVO [order_id=" + order_id + ", order_sender=" + order_sender + ", order_receiver="
				+ order_receiver + ", order_receiver_tel=" + order_receiver_tel + ", order_receiver_addr="
				+ order_receiver_addr + "]";
	}

}
