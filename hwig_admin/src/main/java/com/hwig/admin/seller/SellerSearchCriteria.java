package com.hwig.admin.seller;

import com.hwig.admin.common.SearchCriteria;

public class SellerSearchCriteria extends SearchCriteria {

	private String sel_id;

	public String getSel_id() {
		return sel_id;
	}

	public void setSel_id(String sel_id) {
		this.sel_id = sel_id;
	}

	@Override
	public String toString() {
		return "SellerSearchCriteria [sel_id=" + sel_id + "]";
	}

}
