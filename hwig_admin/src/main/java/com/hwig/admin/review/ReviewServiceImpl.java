package com.hwig.admin.review;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Inject
	ReviewDAO dao;
	
	@Override
	public List<ReviewVO> reviewList(SearchCriteria cri) throws Exception {

		return dao.reviewList(cri);
	}

	@Override
	public int listCount(SearchCriteria cri) throws Exception {
	
		return dao.listCount(cri);
	}

	@Override
	public ReviewVO review_view(int review_id) throws Exception {
		
		return dao.review_view(review_id);
	}

	@Override
	public int review_modify(ReviewVO review) throws Exception {
		
		return dao.review_modify(review);
	}

	@Override
	public int review_delete(int review_id) throws Exception {
		
		return dao.review_delete(review_id);
	}

	@Override
	public void review_id_d(ReviewVO review) throws Exception {
		
		dao.review_id_d(review);
	}

	@Override
	public List<ReviewVO> rv_main_list(int prd_id) throws Exception {
		
		return dao.rv_main_list(prd_id);
	}

	@Override
	public int review_write(ReviewVO review) throws Exception {
		
		return dao.review_write(review);
	}

	@Override
	public List<ReviewVO> rv_mem_list(String mem_id) throws Exception {
		
		return dao.rv_mem_list(mem_id);
	}

	@Override
	public void review_hit(int review_id) throws Exception {
		
		dao.review_hit(review_id);
	}

	@Override
	public int reviewRemove(String mem_id) {
		return dao.reviewDelete(mem_id);
	}


}
