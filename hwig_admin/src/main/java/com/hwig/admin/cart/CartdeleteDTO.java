package com.hwig.admin.cart;

public class CartdeleteDTO {
	
	private int prd_id;
	private String mem_id;
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "CartdeleteDTO [prd_id=" + prd_id + ", mem_id=" + mem_id + "]";
	}
}
