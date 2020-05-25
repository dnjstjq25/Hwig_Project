package com.hwig.admin.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/cart")
public class CartAPIController {

	@Inject
	CartService service;

	// 해당 회원의 장바구니 목록 가져오기
	@RequestMapping(value = "/cartlist", method = RequestMethod.GET)
	public List<CartlistDTO> getCartlist(@RequestParam String mem_id) throws Exception {
		List<CartlistDTO> cartlist = service.cartList(mem_id);

		return cartlist;
	}
	
	//장바구니 갯수 업데이트
	@RequestMapping(value = "/cartupdate", method = RequestMethod.POST)
	public List<CartlistDTO> getCartUpdate(@RequestBody CartupdateDTO cartupdate) throws Exception {
		
		String memid = cartupdate.getMem_id();
		Map<String, Object> cmap = new HashMap<String, Object>();
		
		for(int i=0; i<cartupdate.getOrder_counts().size(); i++) {
				int prdid = cartupdate.getPrd_idss(i);
				int ordercount = cartupdate.getOrder_countss(i);
				
				cmap.put("mem_id", memid);
				cmap.put("prd_id", prdid);
				cmap.put("order_count", ordercount);
				
				service.cartUpdate(cmap);
			}
		
		List<CartlistDTO> cartlist = service.cartList(memid);

		return cartlist;
	}

	// 장바구니에 등록하기
	@RequestMapping(value = "/cartinsert", method = RequestMethod.POST)
	public Map<String, Integer> postCartInsert(@RequestBody CartVO vo) throws Exception {

		int result = service.cartInsert(vo);
		Map<String, Integer> res = new HashMap<String, Integer>();
		res.put("success", result);
		return res;
	}

	// 장바구니에서 삭제하기
	@RequestMapping(value = "/cartdelete", method = RequestMethod.POST)
	public void getCartDelete(@RequestBody CartdeleteDTO cartdelete) throws Exception {
		Map<String, Object> cmap = new HashMap<String, Object>();
		cmap.put("mem_id", cartdelete.getMem_id());
		cmap.put("prd_id", cartdelete.getPrd_id());
		service.cartDelete(cmap);
//		String memid = listdto.getMem_id();
//		Map<String, Object> cmap = new HashMap<String, Object>();
		
//		for(int i=0; i<listdto.getPrd_id().size(); i++) {
//				int prdid = listdto.getPrd_ids(i);
//				cmap.put("mem_id", memid);
//				cmap.put("prd_id", prdid);
//				
//				service.cartDelete(cmap);
//			}
	}
	
	//장바구니 전체삭제
	@RequestMapping(value="/cartalldelete", method = RequestMethod.GET)
	public void getCartAllDelete(@RequestParam String mem_id) throws Exception {
		service.cartAllDelete(mem_id);
	}
	
}
