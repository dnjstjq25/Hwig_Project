package com.hwig.admin.order;

import com.hwig.admin.common.SearchCriteria;

public class OrderCriteria extends SearchCriteria {

	private String sel_id;

	public String getSel_id() {
		return sel_id;
	}

	public void setSel_id(String sel_id) {
		this.sel_id = sel_id;
	}

	@Override
	public String toString() {
		return "OrderCriteria [sel_id=" + sel_id + ", getSearchType()=" + getSearchType() + ", getKeyword()="
				+ getKeyword() + ", toString()=" + super.toString() + ", getPage()=" + getPage() + ", getPageStart()="
				+ getPageStart() + ", getPageEnd()=" + getPageEnd() + ", getPerPageNum()=" + getPerPageNum() + "]";
	}

}
