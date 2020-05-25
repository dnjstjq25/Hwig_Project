package com.hwig.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.product.ProductVO;
import com.hwig.admin.qna.QnaVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;

	@Override
	public AdminVO login(String admin_id, String admin_pw) {
		AdminVO adminVo = new AdminVO();
		adminVo.setAdmin_id(admin_id);
		adminVo.setAdmin_pw(admin_pw);
		return adminDao.select(adminVo);
	}

	@Override
	public int qna_count() {

		return adminDao.qna_select();
	}

	@Override
	public int reply_count() {

		return adminDao.reply_select();
	}

	@Override
	public int member_count() {

		return adminDao.member_select();
	}

	@Override
	public int order_paymoney() {

		return adminDao.order_paymoney();
	}

	@Override
	public List<QnaVO> qna_list() {

		return adminDao.qna_list();
	}

	@Override
	public List<OrderVO> order_list() {

		return adminDao.order_list();
	}

	@Override
	public List<ProductVO> prd_list() {

		return adminDao.prd_list();
	}

	@Override
	public List<ProductVO> chart_circle() {

		return adminDao.chart_circle();
	}

	@Override
	public List<ReviewListVO> review_list(String sel_id) {

		return adminDao.review_list(sel_id);
	}

	@Override
	public List<ProductListVO> sellerPrdsStock(String sel_id) {
		return adminDao.sellerPrdsStock(sel_id);
	}

}
