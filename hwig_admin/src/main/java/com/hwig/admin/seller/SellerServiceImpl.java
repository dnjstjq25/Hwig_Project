package com.hwig.admin.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDAO sellerDao;

	@Override
	public int register(SellerVO sellerVo) {
		return sellerDao.insert(sellerVo);
	}

	@Override
	public SellerVO findOneById(String sel_id) {
		SellerVO sellerVo = new SellerVO();
		sellerVo.setSel_id(sel_id);
		return sellerDao.select(sellerVo);
	}

	@Override
	public int modify(SellerVO sellerVo) {
		return sellerDao.update(sellerVo);
	}

	@Override
	public List<SellerVO> listAll(SearchCriteria cri) {
		return sellerDao.selectAll(cri);
	}

	@Override
	public int listAllCount(SearchCriteria cri) {
		return sellerDao.selectAllCount(cri);
	}

	@Override
	public int pwModify(SellerPwDTO sellerPwDto) {
		return sellerDao.pwUpdate(sellerPwDto);
	}

	@Override
	public List<StockPrdsVO> stockPrdList(SellerSearchCriteria cri) {
		return sellerDao.stockPrdSelect(cri);
	}

	@Override
	public int stockPrdCount(SellerSearchCriteria cri) {
		return sellerDao.stockPrdCount(cri);
	}

}
