package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartDAO {
	//장바구니 목록 가져오기
	public List<CartlistDTO> cartList(String mem_id) throws Exception;

	//장바구니 갯수 수정
	public void cartUpdate(Map<String, Object> cmap) throws Exception;
	
	//장바구니 등록
	public int cartInsert(CartVO vo) throws Exception;
	
	//장바구니 삭제
	public void cartDelete(Map<String, Object> cmap) throws Exception;
	
	//회원탈퇴시 담겨져 있는 상품들 삭제
	public int cartPrdDelete(String order_id);
	
	public void cartAllDelete(String mem_id);
}
