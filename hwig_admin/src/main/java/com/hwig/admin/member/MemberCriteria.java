package com.hwig.admin.member;

public class MemberCriteria {

	private String mem_id;
	private int prdPage;
	private int prdPerPageNum;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public MemberCriteria() {
		this.prdPage = 1;
		this.prdPerPageNum = 10;
	}

	public void setPrdPage(int prdPage) {
		if (prdPage <= 0) {
			this.prdPage = 1;
			return;
		} else {
			this.prdPage = prdPage;
		}
	}

	public void setPrdPerPageNum(int prdPerPageNum) {
		if (prdPerPageNum <= 0 || prdPerPageNum > 100) {
			this.prdPerPageNum = 1;
			return;
		} else {
			this.prdPerPageNum = prdPerPageNum;
		}
	}

	public int getPrdPage() {
		return prdPage;
	}

	public int getPrdPageStart() {
		return (this.prdPage - 1) * prdPage + 1;
	}

	public int getPrdPageEnd() {
		return this.prdPerPageNum * this.prdPage;
	}

	public int getPrdPerPageNum() {
		return this.prdPerPageNum;
	}

	@Override
	public String toString() {
		return "MemberCriteria [mem_id=" + mem_id + ", prdPage=" + prdPage + ", prdPerPageNum=" + prdPerPageNum + "]";
	}

}
