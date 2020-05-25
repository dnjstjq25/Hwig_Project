package com.hwig.admin;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwig.admin.qna.QnaService;

@Controller
public class HomeController {

	@Inject
	AdminService adminService;

	@Inject
	QnaService qService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping("/main")
	public void main(Model model, HttpSession ss) throws Exception {
		model.addAttribute("qna_count", adminService.qna_count());
		model.addAttribute("reply_count", adminService.reply_count());
		model.addAttribute("member_count", adminService.member_count());
		model.addAttribute("order_paymoney", adminService.order_paymoney());
		model.addAttribute("qna_list", adminService.qna_list());
		model.addAttribute("order_list", adminService.order_list());
		model.addAttribute("prd_list", adminService.prd_list());
		model.addAttribute("chart_circle", adminService.chart_circle());

		// 여기부터 판매자 화면
		model.addAttribute("review_list", adminService.review_list((String) ss.getAttribute("user_id")));
		model.addAttribute("data", adminService.sellerPrdsStock((String) ss.getAttribute("user_id")));
	}

}
