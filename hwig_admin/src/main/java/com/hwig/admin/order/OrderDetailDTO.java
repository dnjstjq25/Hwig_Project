package com.hwig.admin.order;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDTO {

	private String order_id;
	private String mem_id;
	private String order_status; // 이건 DB에서
	private int order_reverse;
	private int order_paymoney;
	private String order_payway;
	private String order_paydate;
	private String order_request;
	private int order_count;

	private String mem_name;
	private String mem_tel;

	private String order_receiver_addr;

	private String sel_id;

	private List<OrderDetailPrdDTO> order_prds = new ArrayList<>();

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

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getOrder_receiver_addr() {
		return order_receiver_addr;
	}

	public void setOrder_receiver_addr(String order_receiver_addr) {
		this.order_receiver_addr = order_receiver_addr;
	}

	public List<OrderDetailPrdDTO> getOrder_prds() {
		return order_prds;
	}

	public void setOrder_prds(List<OrderDetailPrdDTO> order_detail_prds) {
		this.order_prds = order_detail_prds;
	}

	public String getSel_id() {
		return sel_id;
	}

	public void setSel_id(String sel_id) {
		this.sel_id = sel_id;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [order_id=" + order_id + ", mem_id=" + mem_id + ", order_status=" + order_status
				+ ", order_reverse=" + order_reverse + ", order_paymoney=" + order_paymoney + ", order_payway="
				+ order_payway + ", order_paydate=" + order_paydate + ", order_request=" + order_request
				+ ", order_count=" + order_count + ", mem_name=" + mem_name + ", mem_tel=" + mem_tel
				+ ", order_receiver_addr=" + order_receiver_addr + ", sel_id=" + sel_id + ", order_prds=" + order_prds
				+ "]";
	}

}
