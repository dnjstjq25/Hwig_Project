package com.hwig.admin.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class QnaDAOImpl implements QnaDAO{

	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.qnaMapper";
	
	
	@Override
	public List<QnaVO> qList(SearchCriteria cri) throws Exception {

		return sql.selectList(namespace + ".qList", cri);
	}

	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return sql.selectOne(namespace + ".listCount", cri);
	}

	@Override
	public int qna_write(QnaVO qna) throws Exception {
		
		return sql.insert(namespace + ".qna_write", qna);
	}

	@Override
	public QnaVO qna_view(int qna_id) throws Exception {
		
		return sql.selectOne(namespace + ".qna_view", qna_id);
	}

	@Override
	public int qna_modify(QnaVO qna) throws Exception {
		
		return sql.update(namespace + ".qna_modify", qna);
	}

	@Override
	public int qna_delete(int qna_id) throws Exception {
		
		return sql.delete(namespace + ".qna_delete", qna_id);
	}

	@Override
	public void qna_id_d(QnaVO qna) throws Exception {
		
		sql.update(namespace + ".qna_id_d", qna);
	}

	@Override
	public List<QnaVO> qList_main(String mem_id) throws Exception {
		
		return sql.selectList(namespace + ".qList_main", mem_id);
	}
}
