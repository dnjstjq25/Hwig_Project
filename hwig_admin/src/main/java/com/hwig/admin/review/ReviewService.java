package com.hwig.admin.review;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface ReviewService {
	public List<ReviewVO> reviewList(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public ReviewVO review_view(int review_id) throws Exception; 
	public int review_modify(ReviewVO review) throws Exception;
	public int review_delete(int review_id) throws Exception;
	public void review_id_d(ReviewVO review) throws Exception;
	
	public List<ReviewVO> rv_main_list(int prd_id) throws Exception;
	public int review_write(ReviewVO review) throws Exception;
	public List<ReviewVO> rv_mem_list(String mem_id) throws Exception;
	public void review_hit(int review_id) throws Exception;
	
	public int reviewRemove(String mem_id);
}
