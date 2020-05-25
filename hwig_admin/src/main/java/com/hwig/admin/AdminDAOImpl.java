package com.hwig.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.product.ProductVO;
import com.hwig.admin.qna.QnaVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.hwig.admin.mappers.adminMapper";

	@Override
	public AdminVO select(AdminVO adminVo) {
		return sqlSession.selectOne(namespace + ".adminSelect", adminVo);
	}

	@Override
	public int qna_select() {

		return sqlSession.selectOne(namespace + ".qna_count");
	}

	@Override
	public int reply_select() {

		return sqlSession.selectOne(namespace + ".reply_count");
	}

	@Override
	public int member_select() {

		return sqlSession.selectOne(namespace + ".member_count");
	}

	@Override
	public int order_paymoney() {

		return sqlSession.selectOne(namespace + ".order_paymoney");
	}

	@Override
	public List<QnaVO> qna_list() {

		return sqlSession.selectList(namespace + ".qna_list");
	}

	@Override
	public List<OrderVO> order_list() {

		return sqlSession.selectList(namespace + ".order_list");
	}

	@Override
	public List<ProductVO> prd_list() {

		return sqlSession.selectList(namespace + ".prd_list");
	}

	@Override
	public List<ProductVO> chart_circle() {

		return sqlSession.selectList(namespace + ".chart_circle");
	}

	@Override
	public List<ReviewListVO> review_list(String sel_id) {

		return sqlSession.selectList(namespace + ".review_list", sel_id);
	}

	@Override
	public List<ProductListVO> sellerPrdsStock(String sel_id) {
		return sqlSession.selectList(namespace + ".sellerPrdsStock", sel_id);
	}

}
