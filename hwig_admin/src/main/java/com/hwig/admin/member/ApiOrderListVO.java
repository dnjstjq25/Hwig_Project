package com.hwig.admin.member;

import com.hwig.admin.common.SearchCriteria;

public class ApiOrderListVO extends SearchCriteria {

	private String mem_id;
//	private String mem_grade;
//	private String mem_name;
//	private int mem_reverse;

	private String order_paydate;
	private String prd_name;
	private String prd_thumb;
	private int order_count;
	private String order_id;
	private int order_paymoney;
	private String order_status;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
//
//	public String getMem_grade() {
//		return mem_grade;
//	}
//
//	public void setMem_grade(String mem_grade) {
//		this.mem_grade = mem_grade;
//	}
//
//	public String getMem_name() {
//		return mem_name;
//	}
//
//	public void setMem_name(String mem_name) {
//		this.mem_name = mem_name;
//	}

	public String getPrd_thumb() {
		return prd_thumb;
	}

	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}

//	public int getMem_reverse() {
//		return mem_reverse;
//	}
//
//	public void setMem_reverse(int mem_reverse) {
//		this.mem_reverse = mem_reverse;
//	}

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
		return "ApiOrderListVO [mem_id=" + mem_id + ", order_paydate=" + order_paydate + ", prd_name=" + prd_name
				+ ", prd_thumb=" + prd_thumb + ", order_count=" + order_count + ", order_id=" + order_id
				+ ", order_paymoney=" + order_paymoney + ", order_status=" + order_status + "]";
	}

}
