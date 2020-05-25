package com.hwig.admin.review;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class ReviewDAOImpl implements ReviewDAO{

	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.reviewMapper";
	
	@Override
	public List<ReviewVO> reviewList(SearchCriteria cri) throws Exception {
		
		return sql.selectList(namespace + ".reviewList", cri);
	}

	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return sql.selectOne(namespace + ".listCount", cri);
	}

	@Override
	public ReviewVO review_view(int review_id) throws Exception {
		
		return sql.selectOne(namespace + ".review_view", review_id);
	}

	@Override
	public int review_modify(ReviewVO review) throws Exception {
		
		return sql.update(namespace + ".review_modify", review);
	}

	@Override
	public int review_delete(int review_id) throws Exception {
		
		return sql.delete(namespace + ".review_delete", review_id);
	}

	@Override
	public void review_id_d(ReviewVO review) throws Exception {
		
		sql.update(namespace + ".review_id_d");
	}

	@Override
	public List<ReviewVO> rv_main_list(int prd_id) throws Exception {
		
		return sql.selectList(namespace + ".rv_main_list", prd_id);
	}

	@Override
	public List<ReviewVO> rv_mem_list(String mem_id) throws Exception {
		
		return sql.selectList(namespace + ".rv_mem_list", mem_id);
	}

	@Override
	public void review_hit(int review_id) throws Exception {
		
		sql.update(namespace + ".rv_hit", review_id);
	}

	@Override
	public int review_write(ReviewVO review) throws Exception {
		
		return sql.insert(namespace + ".review_write", review);
	}

	@Override
	public int reviewDelete(String mem_id) {
		return sql.delete(namespace + ".reviewDelete", mem_id);
	}

	


}
