package com.hwig.admin.member;

import java.util.List;

public class ApiOrderDetailDTO {

	private List<ApiOrderPrdDetailDTO> prdList;
	private ApiOrderMemDetailDTO memData;

	public List<ApiOrderPrdDetailDTO> getPrdList() {
		return prdList;
	}

	public void setPrdList(List<ApiOrderPrdDetailDTO> prdList) {
		this.prdList = prdList;
	}

	public ApiOrderMemDetailDTO getMemData() {
		return memData;
	}

	public void setMemData(ApiOrderMemDetailDTO memData) {
		this.memData = memData;
	}

	@Override
	public String toString() {
		return "ApiOrderDetailDTO [prdList=" + prdList + ", memData=" + memData + "]";
	}

}
