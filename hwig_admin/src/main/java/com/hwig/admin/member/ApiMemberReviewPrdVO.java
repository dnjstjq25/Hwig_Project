package com.hwig.admin.member;

public class ApiMemberReviewPrdVO {

	private String mem_id;
	private String order_paydate;
	private String prd_name;
	private int order_count;
	private String prd_thumb;
	private int prd_id;
	private int order_prd_review;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

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

	public String getPrd_thumb() {
		return prd_thumb;
	}

	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}

	public int getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}

	public int getOrder_prd_review() {
		return order_prd_review;
	}

	public void setOrder_prd_review(int order_prd_review) {
		this.order_prd_review = order_prd_review;
	}

	@Override
	public String toString() {
		return "ApiMemberReviewPrdVO [mem_id=" + mem_id + ", order_paydate=" + order_paydate + ", prd_name=" + prd_name
				+ ", order_count=" + order_count + ", prd_thumb=" + prd_thumb + ", prd_id=" + prd_id
				+ ", order_prd_review=" + order_prd_review + "]";
	}

}
