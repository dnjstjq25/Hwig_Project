package com.hwig.admin.member;

public class MemberReverseVO {

	private String mem_id;
	private int mem_reverse;
	private int mem_used_reverse;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMem_reverse() {
		return mem_reverse;
	}

	public void setMem_reverse(int mem_reverse) {
		this.mem_reverse = mem_reverse;
	}

	public int getMem_used_reverse() {
		return mem_used_reverse;
	}

	public void setMem_used_reverse(int mem_used_reverse) {
		this.mem_used_reverse = mem_used_reverse;
	}

	@Override
	public String toString() {
		return "MemberReverseVO [mem_id=" + mem_id + ", mem_reverse=" + mem_reverse + ", mem_used_reverse="
				+ mem_used_reverse + "]";
	}

}
