package com.hwig.admin.cart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Inject
	CartService service;
	
	//상품 등록 - get
	@RequestMapping(value = "/cart_list", method=RequestMethod.GET)
	public List<CartlistDTO> getCartlist(@RequestParam("mem_id") String mem_id, Model model) throws Exception {
		List<CartlistDTO> cartlist = service.cartList(mem_id);
		model.addAttribute("cartlist", cartlist);
		
		return cartlist;
	}
}
