package com.hwig.admin.member;

public class ApiOrderDetailVO {

	private String mem_id;
	private String order_id;
	private int prd_id;
	private String prd_name;
	private int prd_price;
	private String prd_thumb;
	private int order_count;

	private int order_paymoney;
	private int prd_sale;
	private int order_used_reverse;
	private int order_reverse;
	private String order_payway;

	private String order_sender;
	private String order_paydate;
	private String order_status;

	private String order_receiver;
	private String order_receiver_tel;
	private String order_receiver_addr;

	private String order_request;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

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

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	public int getPrd_sale() {
		return prd_sale;
	}

	public void setPrd_sale(int prd_sale) {
		this.prd_sale = prd_sale;
	}

	public int getOrder_used_reverse() {
		return order_used_reverse;
	}

	public void setOrder_used_reverse(int order_used_reverse) {
		this.order_used_reverse = order_used_reverse;
	}

	public int getOrder_reverse() {
		return order_reverse;
	}

	public void setOrder_reverse(int order_reverse) {
		this.order_reverse = order_reverse;
	}

	public String getOrder_payway() {
		return order_payway;
	}

	public void setOrder_payway(String order_payway) {
		this.order_payway = order_payway;
	}

	public String getOrder_sender() {
		return order_sender;
	}

	public void setOrder_sender(String order_sender) {
		this.order_sender = order_sender;
	}

	public String getOrder_paydate() {
		return order_paydate;
	}

	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
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

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}

	@Override
	public String toString() {
		return "ApiOrderDetailVO [mem_id=" + mem_id + ", order_id=" + order_id + ", prd_id=" + prd_id + ", prd_name="
				+ prd_name + ", prd_price=" + prd_price + ", prd_thumb=" + prd_thumb + ", order_count=" + order_count
				+ ", order_paymoney=" + order_paymoney + ", prd_sale=" + prd_sale + ", order_used_reverse="
				+ order_used_reverse + ", order_reverse=" + order_reverse + ", order_payway=" + order_payway
				+ ", order_sender=" + order_sender + ", order_paydate=" + order_paydate + ", order_status="
				+ order_status + ", order_receiver=" + order_receiver + ", order_receiver_tel=" + order_receiver_tel
				+ ", order_receiver_addr=" + order_receiver_addr + ", order_request=" + order_request + "]";
	}

}
