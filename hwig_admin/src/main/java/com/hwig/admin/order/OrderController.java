package com.hwig.admin.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.seller.SellerController;

@Controller
@RequestMapping("/order/*")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") OrderCriteria cri, Model model) {
		logger.info(cri.toString());

		model.addAttribute("list", orderService.listAll(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(orderService.listAllCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detailPageGET(String order_id, @ModelAttribute("cri") OrderCriteria cri, Model model) {
		logger.info(orderService.findOneById(order_id).toString());
		model.addAttribute("data", orderService.findOneById(order_id));
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

}