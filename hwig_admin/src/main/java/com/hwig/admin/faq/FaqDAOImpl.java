package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class FaqDAOImpl implements FaqDAO {
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.faqMapper";

	//자주묻는질문 리스트
	@Override
	public List<FaqVO> fList(SearchCriteria cri) throws Exception {
		
		return sql.selectList(namespace + ".fList", cri);
	}
	
	//게시글 개수 세기
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return sql.selectOne(namespace + ".listCount", cri);
	}
	
	//자주묻는질문 등록
	@Override
	public int faq_write(FaqVO faq) throws Exception {
		
		return sql.insert(namespace + ".faq_write", faq);
	}
	
	//자주묻는질문 상세보기
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {
		
		return sql.selectOne(namespace + ".faq_view", faq_id);
	}
	
	//자주묻는질문 수정
	@Override
	public int faq_modify(FaqVO faq) throws Exception {
		
		return sql.update(namespace + ".faq_modify", faq);
	}
	
	//자주묻는질문 삭제
	@Override
	public int faq_delete(int faq_id) throws Exception {
		
		return sql.delete(namespace + ".faq_delete", faq_id);
	}

	//�Խñ� ������ ��ȣ �ϳ��� ����
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		sql.update(namespace + ".faq_id_d", faq);	
	}
	
	
	//자주묻는질문 리스트(메인)
	@Override
	public List<FaqVO> fList_main() throws Exception {
		
		return sql.selectList(namespace + ".fList_main");
	}

	
}
