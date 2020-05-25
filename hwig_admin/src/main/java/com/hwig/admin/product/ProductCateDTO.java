package com.hwig.admin.product;

import java.util.List;

public class ProductCateDTO {
	private List<PCategoryDTO> pcategory;
	private List<LCategoryDTO> category;
	private List<ProductListDTO> productlist;
	
	public List<PCategoryDTO> getPcategory() {
		return pcategory;
	}
	public void setPcategory(List<PCategoryDTO> pcategory) {
		this.pcategory = pcategory;
	}
	public List<LCategoryDTO> getCategory() {
		return category;
	}
	public void setCategory(List<LCategoryDTO> category) {
		this.category = category;
	}
	public List<ProductListDTO> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<ProductListDTO> productlist) {
		this.productlist = productlist;
	}
	
	@Override
	public String toString() {
		return "ProductCateDTO [pcategory=" + pcategory + ", category=" + category + ", productlist=" + productlist
				+ "]";
	}
	
}
