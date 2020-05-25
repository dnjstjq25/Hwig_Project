package com.hwig.admin.order;

import java.util.List;

public interface OrderService {

	public List<OrderVO> listAll(OrderCriteria cri);

	public int listAllCount(OrderCriteria cri);

	public OrderDetailDTO findOneById(String order_id);

	public String register(OrderRegisterDTO orderRegisterDto);

	public int statusModify(OrderVO orderVo);

	public ApiOrderCompletionDTO orderCompletion(String order_id);
	
	public int addrRemove(String order_id);
	
	public int orderBRemove(String order_id);
	
	public int orderRemove(String order_id);
	
	public int orderPrdReview(int prd_id);

}
