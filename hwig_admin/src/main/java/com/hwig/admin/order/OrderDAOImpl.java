package com.hwig.admin.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final String namespace = "com.hwig.admin.mappers.orderMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<OrderVO> selectAllBySeller(OrderCriteria cri) {
		return sqlSession.selectList(namespace + ".orderAllSelectSeller", cri);
	}

	@Override
	public int selectAllCountBySeller(OrderCriteria cri) {
		return sqlSession.selectOne(namespace + ".orderAllCountSeller", cri);
	}

	@Override
	public List<OrderVO> selectAllByAdmin(OrderCriteria cri) {
		return sqlSession.selectList(namespace + ".orderAllSelectAdmin", cri);
	}

	@Override
	public int selectAllCountByAdmin(OrderCriteria cri) {
		return sqlSession.selectOne(namespace + ".orderAllCountAdmin", cri);
	}

	@Override
	public OrderDetailDTO selectDetail(OrderDetailDTO orderDto) {
		return sqlSession.selectOne(namespace + ".orderDetailSelect", orderDto);
	}

	@Override
	public List<OrderDetailPrdDTO> selectDetailPrd(OrderDetailDTO orderDto) {
		return sqlSession.selectList(namespace + ".orderDetailPrdSelect", orderDto);
	}

	@Override
	public int orderVoInsert(OrderVO orderVo) {
		return sqlSession.insert(namespace + ".orderInsert", orderVo);
	}

	@Override
	public int orderBVoInsert(OrderBVO orderBVo) {
		return sqlSession.insert(namespace + ".orderBInsert", orderBVo);
	}

	@Override
	public int orderAddrVoInsert(OrderAddrVO orderAddrVo) {
		return sqlSession.insert(namespace + ".orderAddrInsert", orderAddrVo);
	}

	@Override
	public int orderStatusUpdate(OrderVO orderVo) {
		return sqlSession.update(namespace + ".orderStatusUpdate", orderVo);
	}

	@Override
	public ApiOrderCompletionDTO orderCompletion(String order_id) {
		return sqlSession.selectOne(namespace + ".orderCompletion", order_id);
	}

	@Override
	public int addrDelete(String order_id) {
		return sqlSession.delete(namespace + ".addrDelete", order_id);
	}

	@Override
	public int orderBDelete(String order_id) {
		return sqlSession.delete(namespace + ".orderBDelete", order_id);
	}

	@Override
	public int orderDelete(String order_id) {
		return sqlSession.delete(namespace + ".orderDelete", order_id);
	}

	@Override
	public int orderPrdReview(int prd_id) {
		return sqlSession.update(namespace + ".orderPrdReviewUpdate", prd_id);
	}

}
