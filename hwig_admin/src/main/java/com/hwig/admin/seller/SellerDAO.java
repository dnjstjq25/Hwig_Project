package com.hwig.admin.seller;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface SellerDAO {

	public int insert(SellerVO sellerVo);

	public SellerVO select(SellerVO sellerVo);

	public int update(SellerVO sellerVO);

	public List<SellerVO> selectAll(SearchCriteria cri);

	public int selectAllCount(SearchCriteria cri);

	public int pwUpdate(SellerPwDTO sellerPwDto);
	
	public List<StockPrdsVO> stockPrdSelect(SellerSearchCriteria cri);
	
	public int stockPrdCount(SellerSearchCriteria cri);

}
