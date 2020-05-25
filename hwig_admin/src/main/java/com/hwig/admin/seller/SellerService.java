package com.hwig.admin.seller;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface SellerService {

	public int register(SellerVO sellerVo);

	public SellerVO findOneById(String sel_id);

	public int modify(SellerVO sellerVo);

	public List<SellerVO> listAll(SearchCriteria cri);

	public int listAllCount(SearchCriteria cri);

	public int pwModify(SellerPwDTO sellerPwDto);
	
	public List<StockPrdsVO> stockPrdList(SellerSearchCriteria cri);
	
	public int stockPrdCount(SellerSearchCriteria cri);

}
