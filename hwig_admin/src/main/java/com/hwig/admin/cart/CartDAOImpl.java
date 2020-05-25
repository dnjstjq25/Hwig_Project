package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.cartMapper";
	
	//장바구니 목록 가져오기
	@Override
	public List<CartlistDTO> cartList(String mem_id) throws Exception {
		return sql.selectList(namespace + ".cartlist", mem_id);
	}
	
	//장바구니 갯수 수정
	public void cartUpdate(Map<String, Object> cmap) throws Exception{
		sql.update(namespace + ".cartupdate", cmap);
	}
	//장바구니 등록
	@Override
	public int cartInsert(CartVO vo) throws Exception {
		return sql.insert(namespace + ".cartinsert", vo);
	}
	
	//장바구니 삭제
	@Override
	//public void cartDelete(List<CartdeleteDTO> listdto) throws Exception {
	public void cartDelete(Map<String, Object> cmap) throws Exception {
		sql.delete(namespace + ".cartdelete", cmap);
	}

	/*
	 * 회원탈퇴시 장바구니에 담겨져 있는 상품 삭제
	 */
	@Override
	public int cartPrdDelete(String mem_id) {
		return sql.delete(namespace + ".cartPrdDelete", mem_id);
	}
	
	@Override
	public void cartAllDelete(String mem_id) {
		sql.delete(namespace + ".cartAllDelete", mem_id);
	}

}
