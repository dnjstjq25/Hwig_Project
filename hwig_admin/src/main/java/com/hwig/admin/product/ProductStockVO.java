package com.hwig.admin.product;

public class ProductStockVO {

	private int prd_stock;
	private int prd_id;

	public int getPrd_stock() {
		return prd_stock;
	}

	public void setPrd_stock(int prd_stock) {
		this.prd_stock = prd_stock;
	}

	public int getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}

	@Override
	public String toString() {
		return "ProductStockVO [prd_stock=" + prd_stock + ", prd_id=" + prd_id + "]";
	}

}
