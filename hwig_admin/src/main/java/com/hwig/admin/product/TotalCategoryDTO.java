package com.hwig.admin.product;

import java.util.List;

public class TotalCategoryDTO {
	private List<PCategoryDTO> pcategory;
	private List<SCategoryDTO> scategory;
	private List<LCategoryDTO> category;

	public List<PCategoryDTO> getPcategory() {
		return pcategory;
	}

	public void setPcategory(List<PCategoryDTO> pcategory) {
		this.pcategory = pcategory;
	}

	public List<SCategoryDTO> getScategory() {
		return scategory;
	}

	public void setScategory(List<SCategoryDTO> scategory) {
		this.scategory = scategory;
	}

	public List<LCategoryDTO> getCategory() {
		return category;
	}

	public void setCategory(List<LCategoryDTO> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "TotalCategoryDTO [pcategory=" + pcategory + ", category=" + category + "]";
	}

}
