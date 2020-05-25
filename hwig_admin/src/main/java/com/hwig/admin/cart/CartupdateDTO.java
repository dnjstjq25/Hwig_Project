package com.hwig.admin.cart;

import java.util.List;

public class CartupdateDTO {
	private List<Integer> prd_ids;
	private String mem_id;
	private List<Integer> order_counts;
	
	public List<Integer> getPrd_ids() {
		return prd_ids;
	}
	public void setPrd_ids(List<Integer> prd_ids) {
		this.prd_ids = prd_ids;
	}
	public int getPrd_idss(int i) {
		return prd_ids.get(i);
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public List<Integer> getOrder_counts() {
		return order_counts;
	}
	public void setOrder_counts(List<Integer> order_counts) {
		this.order_counts = order_counts;
	}
	public int getOrder_countss(int i) {
		return order_counts.get(i);
	}
	@Override
	public String toString() {
		return "CartupdateDTO [prd_id=" + prd_ids + ", mem_id=" + mem_id + ", order_count=" + order_counts + "]";
	}
}
