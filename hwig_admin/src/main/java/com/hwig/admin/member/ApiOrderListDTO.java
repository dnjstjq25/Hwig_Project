package com.hwig.admin.member;

import java.util.List;

public class ApiOrderListDTO {

	private List<ApiOrderDTO> data;

	public List<ApiOrderDTO> getData() {
		return data;
	}

	public void setData(List<ApiOrderDTO> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiOrderListDTO [data=" + data + "]";
	}

}
