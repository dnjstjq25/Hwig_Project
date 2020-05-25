package com.hwig.admin.order;

import java.util.List;

public interface OrderDAO {

	public List<OrderVO> selectAllBySeller(OrderCriteria cri);

	public int selectAllCountBySeller(OrderCriteria cri);

	public List<OrderVO> selectAllByAdmin(OrderCriteria cri);

	public int selectAllCountByAdmin(OrderCriteria cri);

	public OrderDetailDTO selectDetail(OrderDetailDTO orderDto);

	public List<OrderDetailPrdDTO> selectDetailPrd(OrderDetailDTO orderDto);

	public int orderVoInsert(OrderVO orderVo);

	public int orderBVoInsert(OrderBVO orderBVo);

	public int orderAddrVoInsert(OrderAddrVO orderAddrVo);

	public int orderStatusUpdate(OrderVO orderVo);

	public ApiOrderCompletionDTO orderCompletion(String order_id);
	
	public int addrDelete(String order_id);
	
	public int orderBDelete(String order_id);
	
	public int orderDelete(String order_id);
	
	public int orderPrdReview(int prd_id);

}
