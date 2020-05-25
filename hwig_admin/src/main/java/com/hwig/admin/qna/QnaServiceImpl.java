package com.hwig.admin.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class QnaServiceImpl implements QnaService{

	
	@Inject
	QnaDAO dao;

	@Override
	public List<QnaVO> qList(SearchCriteria cri) throws Exception {
		
		return dao.qList(cri);
	}

	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return dao.listCount(cri);
	}

	@Override
	public int qna_write(QnaVO qna) throws Exception {
		
		return dao.qna_write(qna);
	}

	@Override
	public QnaVO qna_view(int qna_id) throws Exception {
		
		return dao.qna_view(qna_id);
	}

	@Override
	public int qna_modify(QnaVO qna) throws Exception {
		
		return dao.qna_modify(qna);
	}

	@Override
	public int qna_delete(int qna_id) throws Exception {
		
		return dao.qna_delete(qna_id);
	}

	@Override
	public void qna_id_d(QnaVO qna) throws Exception {
		
		dao.qna_id_d(qna);
	}

	@Override
	public List<QnaVO> qList_main(String mem_id) throws Exception {
		
		return dao.qList_main(mem_id);
	}
}
