package com.hwig.admin.product;

import java.util.List;

public class TotalProductDTO {
	private List<ProductWhatDTO> wproduct; //재고많은순
	private List<ProductSaleDTO> sproduct; //할인상품
	private List<ProductNewDTO> nproduct; //신상품
	private List<ProductRandDTO> rproduct; //md추천 - 랜덤1
	private List<ProductRandDTO2> rproduct2; //md추천 - 랜덤2
	
	public List<ProductWhatDTO> getWproduct() {
		return wproduct;
	}
	public void setWproduct(List<ProductWhatDTO> wproduct) {
		this.wproduct = wproduct;
	}
	public List<ProductSaleDTO> getSproduct() {
		return sproduct;
	}
	public void setSproduct(List<ProductSaleDTO> sproduct) {
		this.sproduct = sproduct;
	}
	public List<ProductNewDTO> getNproduct() {
		return nproduct;
	}
	public void setNproduct(List<ProductNewDTO> nproduct) {
		this.nproduct = nproduct;
	}
	public List<ProductRandDTO> getRproduct() {
		return rproduct;
	}
	public void setRproduct(List<ProductRandDTO> rproduct) {
		this.rproduct = rproduct;
	}
	public List<ProductRandDTO2> getRproduct2() {
		return rproduct2;
	}
	public void setRproduct2(List<ProductRandDTO2> rproduct2) {
		this.rproduct2 = rproduct2;
	}
	@Override
	public String toString() {
		return "TotalProduct [wproduct=" + wproduct + ", sproduct=" + sproduct + ", nproduct=" + nproduct
				+ ", rproduct=" + rproduct + ", rproduct2=" + rproduct2 + "]";
	}
	
}
