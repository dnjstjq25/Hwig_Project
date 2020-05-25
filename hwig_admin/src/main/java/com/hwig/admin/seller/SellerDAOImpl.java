package com.hwig.admin.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class SellerDAOImpl implements SellerDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.hwig.admin.mappers.sellerMapper";

	@Override
	public int insert(SellerVO sellerVo) {
		return sqlSession.insert(namespace + ".sellerInsert", sellerVo);
	}

	@Override
	public SellerVO select(SellerVO sellerVo) {
		return sqlSession.selectOne(namespace + ".sellerSelect", sellerVo);
	}

	@Override
	public int update(SellerVO sellerVO) {
		return sqlSession.update(namespace + ".sellerUpdate", sellerVO);
	}

	@Override
	public List<SellerVO> selectAll(SearchCriteria cri) {
		return sqlSession.selectList(namespace + ".sellerAllSelect", cri);
	}

	@Override
	public int selectAllCount(SearchCriteria cri) {
		return sqlSession.selectOne(namespace + ".sellerAllCount", cri);
	}

	@Override
	public int pwUpdate(SellerPwDTO sellerPwDto) {
		return sqlSession.update(namespace + ".sellerPwUpdate", sellerPwDto);
	}

	@Override
	public List<StockPrdsVO> stockPrdSelect(SellerSearchCriteria cri) {
		return sqlSession.selectList(namespace + ".stockPrds", cri);
	}

	@Override
	public int stockPrdCount(SellerSearchCriteria cri) {
		return sqlSession.selectOne(namespace + ".stockPrdsCount", cri);
	}

}
